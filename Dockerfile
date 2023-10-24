# docker/envoy/Dockerfile
FROM envoyproxy/envoy:v1.15.0

COPY ./envoy.yaml /etc/envoy/envoy.yaml

RUN chmod go+r /etc/envoy/envoy.yaml
# CMD /usr/local/bin/envoy -c /etc/envoy/envoy.yaml -l trace --log-path /tmp/envoy_info.log