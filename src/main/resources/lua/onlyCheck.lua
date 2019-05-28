--
-- Created by IntelliJ IDEA.
-- User: liucheng
-- Date: 2019/1/18
-- Time: 14:54
-- To change this template use File | Settings | File Templates.
--
-- 获取键值/参数
local key = KEYS[1]
local parameters = ARGV[1]
-- 通过ZRANGE获取键为key的有序集合元素，偏移量为offset，个数为limit，即所有WEB信息
local nodes = redis.call('SMEMBERS', key)
local list = {}
--for i, v in ipairs(nodes) do
--
--end
for j = 1, #parameters do
    list[j] = parameters[j]
    --if (v == parameters[j]) then
    --    list[i] = v
    --end
end
--for i = 1, #nodes do
--    local hkey = nodes[i]
--    for j = 1, #parameters do
--        if (hkey == parameters[j])
--        then
--            list[i] = hkey
--        end
--    end
--end
-- 将结果返回给redis
return list