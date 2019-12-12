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

加载配置文件：PropertySourcesLoader,PropertySourceLoader

PropertySourceLoader接口：
```
String[] getFileExtensions();
List<PropertySource<?>> load(String name, Resource resource) 
throws IOException;
```

他的2个实现类 PropertiesPropertySourceLoader:加载
.properties 和 .xml;
YamlPropertySourceLoader: 加载.yml,.yaml

ConfigFileApplicationListener

endpoint:/env
EnvironmentMvcEndpoint,EnvironmentAware

bootstrap 配置：
BootstrapApplicationListener：configName
```
//如果配置了spring.cloud.bootstrap.name，则哦那个配置的，否则用bootstrap.yml/properties
String configName = environment
				.resolvePlaceholders("${spring.cloud.bootstrap.name:bootstrap}");
```

application.yml 和 bootstrap.yml 同时存在的时候，只会加载第一个文件.
在 http://localhost:7001/ad-search/actuator/env  ，有2个 applicationConfig：
是application.yml，bootstrap.yml

BootstrapApplicationListener 早于 ConfigFileApplicationListener ,
因为 BootstrapApplicationListener 的 order较高，
BootstrapApplicationListener：DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 5;
ConfigFileApplicationListener：DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 10;


