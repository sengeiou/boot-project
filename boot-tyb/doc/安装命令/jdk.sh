#!/bin/bash
#offline jdk install
ipath="/usr/local"
installpath=$(cd `dirname $0`; pwd)
j=`whereis java`
java=$(echo ${j} | grep "jdk")
echo "11:${ipath}"
echo "22:${installpath}"
echo "33:${j}"
echo "44:${java}"
if [[ "$java" != "" ]]
then
    echo "JDK已经安装"
else
    echo "JDK未安装"
    echo "解压 jdk-*-linux-x64.tar.gz"
    tar -zxvf jdk-8u161-linux-x64.tar.gz >/dev/null 2>&1
    cd jdk* && jdkname=`pwd | awk -F '/' '{print $NF}'`
    echo "获取jdk版本: ${jdkname}"
    cd ${installpath}
    echo "获取当前目录:${installpath}"
    mv ${jdkname} ${ipath}
    echo "转移${jdkname}文件到${ipath}安装目录"
    echo "jdk安装目录:${ipath}/${jdkname}"
    echo "#JDK环境变量配置" >> /etc/profile
    echo "export JAVA_HOME=${ipath}/${jdkname}" >> /etc/profile
    echo 'export JRE_HOME=${JAVA_HOME}/jre' >> /etc/profile
    echo 'export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib' >> /etc/profile
    echo 'export PATH=${JAVA_HOME}/bin:$PATH' >> /etc/profile
    source /etc/profile > /dev/null 2>&1
    echo "jdk 安装完毕!"
    source /etc/profile
	echo "验证java-version!"
	java-version
fi