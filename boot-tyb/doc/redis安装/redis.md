##redis安装
- 解压缩后指定安装路径 
make PREFIX=/usr/local/redis install
- 也可以直接 make (默认安装在usr/local/)
- make install 
- cp redis.cof /etc 拷贝redis.cof 到etc
- 然后编辑文件daemonize 节点no改为yes
/usr/local/bin/redis-server  /etc/redis.conf 
- 添加开机自启 vi /etc/init.d/redis
- 检查redis进程是否已经启动
ps -ef | grep -i redis 
杀死 kill -9 12394
