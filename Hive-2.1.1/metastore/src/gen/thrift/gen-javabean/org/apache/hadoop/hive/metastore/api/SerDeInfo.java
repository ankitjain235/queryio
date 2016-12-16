/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hive.metastore.api;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class SerDeInfo implements org.apache.thrift.TBase<SerDeInfo, SerDeInfo._Fields>, java.io.Serializable, Cloneable, Comparable<SerDeInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SerDeInfo");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField SERIALIZATION_LIB_FIELD_DESC = new org.apache.thrift.protocol.TField("serializationLib", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField("parameters", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SerDeInfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SerDeInfoTupleSchemeFactory());
  }

  private String name; // required
  private String serializationLib; // required
  private Map<String,String> parameters; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    SERIALIZATION_LIB((short)2, "serializationLib"),
    PARAMETERS((short)3, "parameters");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // SERIALIZATION_LIB
          return SERIALIZATION_LIB;
        case 3: // PARAMETERS
          return PARAMETERS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SERIALIZATION_LIB, new org.apache.thrift.meta_data.FieldMetaData("serializationLib", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAMETERS, new org.apache.thrift.meta_data.FieldMetaData("parameters", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SerDeInfo.class, metaDataMap);
  }

  public SerDeInfo() {
  }

  public SerDeInfo(
    String name,
    String serializationLib,
    Map<String,String> parameters)
  {
    this();
    this.name = org.apache.hive.common.util.HiveStringUtils.intern(name);
    this.serializationLib = org.apache.hive.common.util.HiveStringUtils.intern(serializationLib);
    this.parameters = org.apache.hive.common.util.HiveStringUtils.intern(parameters);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SerDeInfo(SerDeInfo other) {
    if (other.isSetName()) {
      this.name = org.apache.hive.common.util.HiveStringUtils.intern(other.name);
    }
    if (other.isSetSerializationLib()) {
      this.serializationLib = org.apache.hive.common.util.HiveStringUtils.intern(other.serializationLib);
    }
    if (other.isSetParameters()) {
      Map<String,String> __this__parameters = new HashMap<String,String>(other.parameters);
      this.parameters = __this__parameters;
    }
  }

  public SerDeInfo deepCopy() {
    return new SerDeInfo(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.serializationLib = null;
    this.parameters = null;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = org.apache.hive.common.util.HiveStringUtils.intern(name);
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getSerializationLib() {
    return this.serializationLib;
  }

  public void setSerializationLib(String serializationLib) {
    this.serializationLib = org.apache.hive.common.util.HiveStringUtils.intern(serializationLib);
  }

  public void unsetSerializationLib() {
    this.serializationLib = null;
  }

  /** Returns true if field serializationLib is set (has been assigned a value) and false otherwise */
  public boolean isSetSerializationLib() {
    return this.serializationLib != null;
  }

  public void setSerializationLibIsSet(boolean value) {
    if (!value) {
      this.serializationLib = null;
    }
  }

  public int getParametersSize() {
    return (this.parameters == null) ? 0 : this.parameters.size();
  }

  public void putToParameters(String key, String val) {
    if (this.parameters == null) {
      this.parameters = new HashMap<String,String>();
    }
    this.parameters.put(key, val);
  }

  public Map<String,String> getParameters() {
    return this.parameters;
  }

  public void setParameters(Map<String,String> parameters) {
    this.parameters = org.apache.hive.common.util.HiveStringUtils.intern(parameters);
  }

  public void unsetParameters() {
    this.parameters = null;
  }

  /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
  public boolean isSetParameters() {
    return this.parameters != null;
  }

  public void setParametersIsSet(boolean value) {
    if (!value) {
      this.parameters = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case SERIALIZATION_LIB:
      if (value == null) {
        unsetSerializationLib();
      } else {
        setSerializationLib((String)value);
      }
      break;

    case PARAMETERS:
      if (value == null) {
        unsetParameters();
      } else {
        setParameters((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case SERIALIZATION_LIB:
      return getSerializationLib();

    case PARAMETERS:
      return getParameters();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case SERIALIZATION_LIB:
      return isSetSerializationLib();
    case PARAMETERS:
      return isSetParameters();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SerDeInfo)
      return this.equals((SerDeInfo)that);
    return false;
  }

  public boolean equals(SerDeInfo that) {
    if (that == null)
      return false;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_serializationLib = true && this.isSetSerializationLib();
    boolean that_present_serializationLib = true && that.isSetSerializationLib();
    if (this_present_serializationLib || that_present_serializationLib) {
      if (!(this_present_serializationLib && that_present_serializationLib))
        return false;
      if (!this.serializationLib.equals(that.serializationLib))
        return false;
    }

    boolean this_present_parameters = true && this.isSetParameters();
    boolean that_present_parameters = true && that.isSetParameters();
    if (this_present_parameters || that_present_parameters) {
      if (!(this_present_parameters && that_present_parameters))
        return false;
      if (!this.parameters.equals(that.parameters))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_name = true && (isSetName());
    list.add(present_name);
    if (present_name)
      list.add(name);

    boolean present_serializationLib = true && (isSetSerializationLib());
    list.add(present_serializationLib);
    if (present_serializationLib)
      list.add(serializationLib);

    boolean present_parameters = true && (isSetParameters());
    list.add(present_parameters);
    if (present_parameters)
      list.add(parameters);

    return list.hashCode();
  }

  @Override
  public int compareTo(SerDeInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSerializationLib()).compareTo(other.isSetSerializationLib());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSerializationLib()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serializationLib, other.serializationLib);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParameters()).compareTo(other.isSetParameters());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParameters()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("SerDeInfo(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("serializationLib:");
    if (this.serializationLib == null) {
      sb.append("null");
    } else {
      sb.append(this.serializationLib);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("parameters:");
    if (this.parameters == null) {
      sb.append("null");
    } else {
      sb.append(this.parameters);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SerDeInfoStandardSchemeFactory implements SchemeFactory {
    public SerDeInfoStandardScheme getScheme() {
      return new SerDeInfoStandardScheme();
    }
  }

  private static class SerDeInfoStandardScheme extends StandardScheme<SerDeInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SerDeInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SERIALIZATION_LIB
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.serializationLib = iprot.readString();
              struct.setSerializationLibIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARAMETERS
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map104 = iprot.readMapBegin();
                struct.parameters = new HashMap<String,String>(2*_map104.size);
                String _key105;
                String _val106;
                for (int _i107 = 0; _i107 < _map104.size; ++_i107)
                {
                  _key105 = iprot.readString();
                  _val106 = iprot.readString();
                  struct.parameters.put(_key105, _val106);
                }
                iprot.readMapEnd();
              }
              struct.setParametersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, SerDeInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.serializationLib != null) {
        oprot.writeFieldBegin(SERIALIZATION_LIB_FIELD_DESC);
        oprot.writeString(struct.serializationLib);
        oprot.writeFieldEnd();
      }
      if (struct.parameters != null) {
        oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.parameters.size()));
          for (Map.Entry<String, String> _iter108 : struct.parameters.entrySet())
          {
            oprot.writeString(_iter108.getKey());
            oprot.writeString(_iter108.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SerDeInfoTupleSchemeFactory implements SchemeFactory {
    public SerDeInfoTupleScheme getScheme() {
      return new SerDeInfoTupleScheme();
    }
  }

  private static class SerDeInfoTupleScheme extends TupleScheme<SerDeInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetSerializationLib()) {
        optionals.set(1);
      }
      if (struct.isSetParameters()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetSerializationLib()) {
        oprot.writeString(struct.serializationLib);
      }
      if (struct.isSetParameters()) {
        {
          oprot.writeI32(struct.parameters.size());
          for (Map.Entry<String, String> _iter109 : struct.parameters.entrySet())
          {
            oprot.writeString(_iter109.getKey());
            oprot.writeString(_iter109.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.serializationLib = iprot.readString();
        struct.setSerializationLibIsSet(true);
      }
      if (incoming.get(2)) {
        {
          org.apache.thrift.protocol.TMap _map110 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.parameters = new HashMap<String,String>(2*_map110.size);
          String _key111;
          String _val112;
          for (int _i113 = 0; _i113 < _map110.size; ++_i113)
          {
            _key111 = iprot.readString();
            _val112 = iprot.readString();
            struct.parameters.put(_key111, _val112);
          }
        }
        struct.setParametersIsSet(true);
      }
    }
  }

}

