--
-- Created by IntelliJ IDEA.
-- User: liucheng
-- Date: 2019/1/18
-- Time: 15:11
-- To change this template use File | Settings | File Templates.
--
--载入脚本到redis缓存 ARGV[1] 脚本参数
return redis.call('SCRIPT LOAD',"return 'hello lc'")