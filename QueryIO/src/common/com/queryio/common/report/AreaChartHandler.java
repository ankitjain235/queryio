package com.queryio.common.report;

import java.util.Iterator;

import org.apache.commons.lang.WordUtils;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.Angle3D;
import org.eclipse.birt.chart.model.attribute.AngleType;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.Orientation;
import org.eclipse.birt.chart.model.attribute.Rotation3D;
import org.eclipse.birt.chart.model.attribute.SortOption;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.impl.Angle3DImpl;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.InsetsImpl;
import org.eclipse.birt.chart.model.attribute.impl.LineAttributesImpl;
import org.eclipse.birt.chart.model.attribute.impl.Rotation3DImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Label;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.AxisImpl;
import org.eclipse.birt.chart.model.component.impl.LabelImpl;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.Query;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.SeriesGrouping;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.data.impl.QueryImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesGroupingImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.ClientArea;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.layout.Plot;
import org.eclipse.birt.chart.model.type.impl.AreaSeriesImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.queryio.core.customtags.BigQueryIdentifiers;

public class AreaChartHandler {

	public static Chart getAreaChart(String title, int dimension, int chartWidth, int chartHeight,
			JSONObject xSeriesObj, JSONObject ySeriesJSON, String xSeriesTitle, String ySeriesTitle,
			JSONObject chartPreferences, boolean isHive, String yGrouping) throws Exception {

		JSONObject titleJSON = (JSONObject) chartPreferences.get("titleJson");
		JSONObject commonJSON = (JSONObject) chartPreferences.get("commonJson");

		ChartWithAxes chart = ChartWithAxesImpl.create();

		chart.setType("Area Chart");
		chart.setSubType("Standard");
		Plot p = chart.getPlot();

		if (dimension == ChartDimension.THREE_DIMENSIONAL && ySeriesJSON.size() > 1) {
			dimension = ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH;

		}

		switch (dimension) {
		case ChartDimension.TWO_DIMENSIONAL:
			chart.setDimension(ChartDimension.TWO_DIMENSIONAL_LITERAL);
			break;
		case ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH:
			chart.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
			break;
		case ChartDimension.THREE_DIMENSIONAL:
			chart.setDimension(ChartDimension.THREE_DIMENSIONAL_LITERAL);
			break;
		default:
			chart.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
			break;
		}
		chart.getBlock().getBounds().setWidth(chartWidth);
		chart.getBlock().getBounds().setHeight(chartHeight);
		chart.getBlock().getOutline().setVisible(true);

		// Plot
		chart.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		chart.getPlot().getClientArea().setBackground(ColorDefinitionImpl.WHITE());

		// Title
		chart.getPlot().setBackground(ColorDefinitionImpl.WHITE());
		chart.getPlot().getClientArea().setBackground(ColorDefinitionImpl.TRANSPARENT());

		/* Legend */
		Legend legend = chart.getLegend();
		JSONObject legendProperties = (JSONObject) chartPreferences.get("legendJson");
		ChartPreferenceHandler.setLegendProperties(legendProperties, legend, ySeriesTitle);

		chart.getTitle().getLabel().getCaption().setValue(title);
		chart.getTitle().getLabel().getCaption().getFont().setSize(14);

		Axis xAxis = chart.getPrimaryBaseAxes()[0];

		/* Setting X-axis properties. */
		JSONObject xAxisProperties = (JSONObject) chartPreferences.get("xAxisJson");
		ChartPreferenceHandler.setXAxisProperties(xAxis, xAxisProperties, xSeriesTitle);

		/* Plot */
		JSONArray topColors = null;
		if (commonJSON != null) {

			chart.getBlock().setBackground(ChartPreferenceHandler.hexToRGB((String) commonJSON.get("background")));
			p.setBackground(ChartPreferenceHandler.hexToRGB((String) commonJSON.get("plotBackground")));
			chart.getBlock().getBounds().setWidth(chartWidth);
			chart.getBlock().getBounds().setHeight(chartHeight);
			/* Client */
			ClientArea clientArea = p.getClientArea();
			clientArea.setBackground(ChartPreferenceHandler.hexToRGB((String) commonJSON.get("clientBackground")));
			// Empty message
			String msg = (String) commonJSON.get("emptyChartMessage");
			if (msg != null && msg.length() > 0) {
				chart.getEmptyMessage().setVisible(true);
				chart.getEmptyMessage().getCaption().setValue(msg);
			}
			// Series palette
			topColors = (JSONArray) commonJSON.get("topColors");
		}

		Series seriesX = SeriesImpl.create();

		String xSeries = (String) xSeriesObj.get(BigQueryIdentifiers.X_SERIES);
		if (isHive) {
			xSeries = xSeries.toLowerCase();
		}
		Query xQuery = QueryImpl.create("row[\"" + xSeries + "\"]");
		seriesX.getDataDefinition().add(xQuery);
		seriesX.setSeriesIdentifier(xSeriesTitle);

		SeriesDefinition xSeriesDef = SeriesDefinitionImpl.create();
		xAxis.getSeriesDefinitions().add(xSeriesDef);
		if (topColors != null) {
			for (int i = 0; i < topColors.size(); i++) {
				xSeriesDef.getSeriesPalette().getEntries()
						.add(ChartPreferenceHandler.hexToRGB((String) topColors.get(i)));
			}
		}
		xSeriesDef.getSeriesPalette().shift(0);
		xSeriesDef.getSeries().add(seriesX);

		String sortType = (String) xSeriesObj.get(BigQueryIdentifiers.X_SERIES_SORT_TYPE);

		if (!BigQueryIdentifiers.X_SERIES_SORT_TYPE_NONE.equalsIgnoreCase(sortType)) {
			String sortColumn = (String) xSeriesObj.get(BigQueryIdentifiers.X_SERIES_SORT_COLUMN);
			Query xSortQuery = QueryImpl.create("row[\"" + sortColumn + "\"]");

			if (BigQueryIdentifiers.X_SERIES_SORT_TYPE_ASCENDING.equalsIgnoreCase(sortType))
				xSeriesDef.setSorting(SortOption.ASCENDING_LITERAL);
			else
				xSeriesDef.setSorting(SortOption.DESCENDING_LITERAL);

			xSeriesDef.setSortKey(xSortQuery);
			xSeriesDef.setSortStrength(2);
		}

		ChartPreferenceHandler.setTitleProperties(titleJSON, chart, title);
		// Chart Out Line
		JSONObject chartOutLine = (JSONObject) chartPreferences.get("outLineJson");
		if (chartOutLine != null && chartOutLine.size() > 0) {
			Boolean isChartOutLineVisible = (Boolean) chartOutLine.get("visible");
			if (isChartOutLineVisible) {
				int chartOutlineWidthInt = Integer.parseInt((String) chartOutLine.get("width"));
				String titleOutlineColor = (String) chartOutLine.get("color");
				chart.getBlock()
						.setOutline(LineAttributesImpl.create(ChartPreferenceHandler.hexToRGB(titleOutlineColor),
								ChartPreferenceHandler.getLineStyleType((String) chartOutLine.get("style")),
								chartOutlineWidthInt));
			}

		}
		// Chart insets.
		JSONObject chartInsets = (JSONObject) chartPreferences.get("insetsJson");
		if (chartInsets != null && chartInsets.size() > 0) {
			int titleInsetTop = Integer.parseInt((String) chartInsets.get("top"));
			int titleInsetBottom = Integer.parseInt((String) chartInsets.get("bottom"));
			int titleInsetLeft = Integer.parseInt((String) chartInsets.get("left"));
			int titleInsetRight = Integer.parseInt((String) chartInsets.get("right"));
			chart.getTitle()
					.setInsets(InsetsImpl.create(titleInsetTop, titleInsetLeft, titleInsetBottom, titleInsetRight));
		}

		boolean primary = true;
		SeriesGrouping seriesGroup = SeriesGroupingImpl.create();
		seriesGroup.setEnabled(true);

		xSeriesDef.setGrouping(seriesGroup);

		Iterator it = ySeriesJSON.keySet().iterator();
		int i = 0;

		while (it.hasNext()) {
			Series seriesY = (Series) AreaSeriesImpl.create();
			seriesY.getLabel().setVisible(false);
			/* Setting Y-Series data Label Properties. */
			JSONObject labelProperties = (JSONObject) chartPreferences.get("labelJson");
			ChartPreferenceHandler.setLabelProperties(labelProperties, seriesY, true, dimension);

			String ySeries = (String) it.next();
			String function = (String) ySeriesJSON.get(ySeries);

			Axis yAxis;

			if (primary) {
				// Y-Axis
				yAxis = chart.getPrimaryOrthogonalAxis(xAxis);
				yAxis.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
				yAxis.getTitle().setVisible(true);
				yAxis.setSideBySide(true);

				primary = false;
			} else {
				// Y-Axis (2)
				yAxis = AxisImpl.create(Axis.ORTHOGONAL);
				yAxis.setType(AxisType.LINEAR_LITERAL);
				yAxis.getMajorGrid().setTickStyle(TickStyle.RIGHT_LITERAL);
				xAxis.getAssociatedAxes().add(yAxis);
				yAxis.setSideBySide(true);
			}

			/* Setting Y-axis properties. */
			JSONObject yAxisProperties = (JSONObject) chartPreferences.get("yAxisJson");
			ChartPreferenceHandler.setYAxisProperties(yAxis, yAxisProperties, ySeriesTitle);

			if (isHive) {
				ySeries = ySeries.toLowerCase();
			}
			Query yQuery = QueryImpl.create("row[\"" + ySeries + "\"]");
			if ((function != null) && !(function.equals("#"))) {
				SeriesGrouping ySeriesGroup = SeriesGroupingImpl.create();
				ySeriesGroup.setEnabled(true);
				if (function.equalsIgnoreCase("DISTINCTCOUNT"))
					ySeriesGroup.setAggregateExpression(function);
				else
					ySeriesGroup.setAggregateExpression(WordUtils.capitalize(function.toLowerCase()));

				yQuery.setGrouping(ySeriesGroup);
			}
			seriesY.getDataDefinition().add(yQuery);
			Label baseTitle = LabelImpl.create();
			baseTitle.getCaption().setValue(ySeries);
			seriesY.setSeriesIdentifier(baseTitle.getCaption().getValue());
			SeriesDefinition ySeriesDef = SeriesDefinitionImpl.create();
			if (topColors != null && i < topColors.size()) {
				ySeriesDef.getSeriesPalette().getEntries()
						.add(ChartPreferenceHandler.hexToRGB((String) topColors.get(i), 100));
			}
			yAxis.getSeriesDefinitions().add(ySeriesDef);
			ySeriesDef.getSeries().add(seriesY);
			if (yGrouping != null && !("none".equalsIgnoreCase(yGrouping)) && !("".equals(yGrouping))) {
				SeriesDefinition sdGroup = SeriesDefinitionImpl.create();
				Query query = QueryImpl.create("row[\"" + yGrouping + "\"]");
				sdGroup.setQuery(query);
				yAxis.getSeriesDefinitions().clear(); // Clear the original
				yAxis.getSeriesDefinitions().add(0, sdGroup);
				sdGroup.getSeries().add(ySeriesDef.getSeries().get(0));
			}
			i++;
		}

		if (dimension == ChartDimension.THREE_DIMENSIONAL) {
			Axis zAxis = AxisImpl.create(Axis.ANCILLARY_BASE);
			zAxis.setType(AxisType.TEXT_LITERAL);
			zAxis.getTitle().getCaption().setValue("Z - Axis Title");
			zAxis.setPrimaryAxis(true);

			zAxis.getOrigin().setType(IntersectionType.MIN_LITERAL);
			zAxis.getOrigin().setValue(NumberDataElementImpl.create(0.0));

			SeriesDefinition zSeriesDef = SeriesDefinitionImpl.create();
			zSeriesDef.getSeriesPalette().shift(-(i + 2));
			zSeriesDef.getSeries().add(SeriesImpl.create());

			zAxis.getSeriesDefinitions().add(zSeriesDef);
			zAxis.setOrientation(Orientation.HORIZONTAL_LITERAL);
			xAxis.getAncillaryAxes().add(zAxis);
			xAxis.setCategoryAxis(true);

			chart.setOrientation(Orientation.VERTICAL_LITERAL);
			chart.setUnitSpacing(50.0);

			Angle3D angle3D = Angle3DImpl.create(-20.0, 45.0, 0.0);
			angle3D.setType(AngleType.NONE_LITERAL);

			Angle3D[] angle3DArray = new Angle3D[1];
			angle3DArray[0] = angle3D;

			Rotation3D rotation3D = Rotation3DImpl.create(angle3DArray);
			chart.setRotation(rotation3D);
			String wallBackground = (String) commonJSON.get("wallBackground");
			String floorBackground = (String) commonJSON.get("floorBackground");
			chart.setWallFill(ChartPreferenceHandler.hexToRGB(wallBackground));
			chart.setFloorFill(ChartPreferenceHandler.hexToRGB(floorBackground));
		}
		return chart;
	}

}
