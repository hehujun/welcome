version 1.0
    spring中使用slf4j，代替common-logging
    具体参考spring documentwend
    SLF4J is a cleaner dependency and more efficient at runtime than commons-logging because it uses compile-time bindings instead of runtime discovery of the other logging frameworks it integrates. This also means that you have to be more explicit about what you want to happen at runtime, and declare it or configure it accordingly. SLF4J provides bindings to many common logging frameworks, so you can usually choose one that you already use, and bind to that for configuration and management.
    SLF4J provides bindings to many common logging frameworks, including JCL, and it also does the reverse: bridges between other logging frameworks and itself. So to use SLF4J with Spring you need to replace the commons-logging dependency with the SLF4J-JCL bridge. Once you have done that then logging calls from within Spring will be translated into logging calls to the SLF4J API, so if other libraries in your application use that API, then you have a single place to configure and manage logging.

version 1.1
    springmvc视图解析 有个问题是freemarker的视图解析必须在JSP之前  否则页面找不到,原因为项目当中JSP为默认解析器
    <!-- 配置freeMarker视图解析器 -->
        <bean id="viewResolverFtl" class="org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver">
            <property name="viewClass" value="org.springframework.web.servlet.view.freemarker.FreeMarkerView"/>
            <property name="contentType" value="text/html; charset=UTF-8"/>
            <property name="exposeRequestAttributes" value="true"/>
            <property name="exposeSessionAttributes" value="true"/>
            <property name="exposeSpringMacroHelpers" value="true"/>
            <property name="cache" value="true"/>
            <property name="suffix" value=".ftl"/>
            <property name="order" value="0"/>
        </bean>

        <!-- 配置freeMarker的模板路径 -->
        <bean id="freemarkerConfig" class="org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer">
            <property name="templateLoaderPath" value="/WEB-INF/freemarker/"/>
            <property name="freemarkerVariables">
                <map>
                    <entry key="xml_escape" value-ref="fmXmlEscape"/>
                </map>
            </property>
            <property name="defaultEncoding" value="UTF-8"/>
            <property name="freemarkerSettings">
                <props>
                    <prop key="template_update_delay">3600</prop>
                    <prop key="locale">zh_CN</prop>
                    <prop key="datetime_format">yyyy-MM-dd HH:mm:ss</prop>
                    <prop key="date_format">yyyy-MM-dd</prop>
                    <prop key="number_format">#.##</prop>
                </props>
            </property>
        </bean>

        <bean id="fmXmlEscape" class="freemarker.template.utility.XmlEscape"/>