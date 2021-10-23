FROM registry.cn-shanghai.aliyuncs.com/jicco/8-jdk-alpine

COPY sentinel-dashboard.jar sentinel-dashboard.jar

ENV JAVA_OPTS="-Dserver.port=8080 \
	-Dcsp.sentinel.dashboard.server=localhost:8080 \
	-Dsentinel.dashboard.auth.username=xxx \
	-Dsentinel.dashboard.auth.password=xxx \
	-Dredis.host=xxx \
	-Dredis.port=6379 \
	-Dredis.password=xxx \
	-Dredis.publish.channel=sentinel \
	-Dsentinel.rule.flow.key=sentinel:flow:"

ENTRYPOINT java ${JAVA_OPTS} -jar sentinel-dashboard.jar

EXPOSE 8080