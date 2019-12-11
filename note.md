1.microsservice:

点对点调用

2.mysql binlog:二进制日志：记录对数据发生更改的sql语句。
以二进制形式 保存到磁盘。

三种格式：

row: 不记录sql,记录修改细节。

statement:记录sql.

mixed: row+statement.

binlog sql语句：

show master logs; 日志列表

show master status; 最后一个日志 编号名称

flush logs;刷新

reset logs:clear。

spring env:

1.profiles: 调用 ConfigurableEnvironment 接口 设置 profile 激活。

ConfigurableEnvironment 的方法：
```
void setActiveProfiles(String... profiles);
//Add a profile to the current set of active profiles.
void addActiveProfile(String profile);
```

2.property: PropertySources,PropertySource

PropertySources 实现类：MutablePropertySources