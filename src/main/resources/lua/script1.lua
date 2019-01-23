--
-- Created by IntelliJ IDEA.
-- User: liucheng
-- Date: 2019/1/18
-- Time: 14:54
-- To change this template use File | Settings | File Templates.
--
-- 获取键值/参数
local key = KEYS[1]
-- 通过ZRANGE获取键为key的有序集合元素，偏移量为offset，个数为limit，即所有WEB信息
local nodes = redis.call('SMEMBERS', key)
---- infos table 存储所有WEB信息
local list = {}
for i = 1, #nodes do
    local hkey = key .. ':' .. nodes[i]
    local hinfo = redis.call('HGETALL', hkey)
    local value = ''
    local score = ''
    local infos = {}
    local index = 0
    for info_key, info_value in pairs(hinfo) do
        -- 奇数key 对应val是　key
        -- 偶数key 对应val是　value
        if (info_key % 2 == 1)
        then
            value = info_value
        else
            score = info_value
            infos[index] = value .. ':' .. score .. ';'
            index = index + 1
        end
    end
    list[i] = cjson.encode(infos)
end
-- 将结果返回给redis
return list