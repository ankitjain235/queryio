USER_INSTALL_DIR="$(dirname "$( cd "$( dirname "$0" )" && pwd )")"

echo "$USER_INSTALL_DIR"

PROP_FILE=$USER_INSTALL_DIR/bin/qio-setup.properties

source $PROP_FILE

echo "$ADD_USER"
echo "$CustomDBPass"
echo "$CustomDBUser"
echo "$DB_PORT1"
echo "$DB_PORT2"
echo "$IP"
echo "$IS_INSTALL"
echo "$QIO_EMAIL"
echo "$QIO_FNAME"
echo "$QIO_LNAME"
echo "$QIO_PASSWORD"
echo "$QIO_USER"
echo "$SHUTDOWN_PORT"
echo "$STARTUP_PORT"
echo "$SysDBPass"
echo "$SysDBUser"
echo "$SSH_HOSTNAME"

chmod -R +x $USER_INSTALL_DIR

find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$USER_INSTALL_DIR\$'"~$USER_INSTALL_DIR"'~g'
echo "Done USER_INSTALL_DIR"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$CustomDBPass\$'"~$CustomDBPass"'~g'
echo "Done CustomDBPass"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$CustomDBUser\$'"~$CustomDBUser"'~g'
echo "Done CustomDBUser"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$DB_PORT1\$'"~$DB_PORT1"'~g'
echo "Done DB_PORT1"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$DB_PORT2\$'"~$DB_PORT2"'~g'
echo "Done DB_PORT2"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$IP\$'"~$IP"'~g'
echo "Done IP"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$IS_INSTALL\$'"~$IS_INSTALL"'~g'
echo "Done IS_INSTALL"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$QIO_EMAIL\$'"~$QIO_EMAIL"'~g'
echo "Done QIO_EMAIL"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$QIO_FNAME\$'"~$QIO_FNAME"'~g'
echo "Done QIO_FNAME"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$QIO_LNAME\$'"~$QIO_LNAME"'~g'
echo "Done QIO_LNAME"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$QIO_PASSWORD\$'"~$QIO_PASSWORD"'~g'
echo "Done QIO_PASSWORD"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$QIO_USER\$'"~$QIO_USER"'~g'
echo "Done QIO_USER"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$SHUTDOWN_PORT\$'"~$SHUTDOWN_PORT"'~g'
echo "Done SHUTDOWN_PORT"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$STARTUP_PORT\$'"~$STARTUP_PORT"'~g'
echo "Done STARTUP_PORT"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$SysDBPass\$'"~$SysDBPass"'~g'
echo "Done SysDBPass"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$SysDBUser\$'"~$SysDBUser"'~g'
echo "Done SysDBUser"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$ADD_USER\$'"~$ADD_USER"'~g'
echo "Done ADD_USER"
find $USER_INSTALL_DIR -type f \( -name "*.properties" -or -name "*.sh" -or -name "*.script" -or -name "*.xml" \) -print0 | xargs -0 sed -i 's~\$SSH_HOSTNAME\$'"~$SSH_HOSTNAME"'~g'
echo "Done SSH_HOSTNAME"

cp $USER_INSTALL_DIR/bin/.queryio.install $HOME
