FROM redis:4.0.6-alpine

ADD redis.conf /etc/redis.conf

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["redis-server","/etc/redis.conf"]
