FROM redis:4.0.6-alpine

ADD redis.conf /etc/redis.conf
RUN apk update && apk add iftop

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["redis-server","/etc/redis.conf"]
