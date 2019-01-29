@file:JvmName("SpringContextUtils")
package com.xzm.tyb.utils


/**
 * User: Cuiyalei
 * Date: 2018/4/16
 * Time: 14:15
 * Pack: com.wuyu.config.utils.SpringContext
 * Description: the is SpringContext Description
 */
lateinit var identity: Identity
//    private set
//lateinit var applicationContext: ApplicationContext
//operator fun <P : Any> ApplicationContext.get(clazz: KClass<P>): P {
//    return applicationContext.getBean(clazz.java)
//}
//operator fun <P : Any> ApplicationContext.get(clazz: Class<P>): P {
//    return applicationContext.getBean(clazz)
//}
//fun ApplicationContext.getMessage(key: String, vararg args: Any?): String {
//    return this[MessageSource::class].getMessage(key, args, Locale.CHINA)
//}
//fun ApplicationContext.register(clazz: Class<*>){
//    val defaultListableBeanFactory=(this as ConfigurableApplicationContext).beanFactory as DefaultListableBeanFactory
//    defaultListableBeanFactory.registerBeanDefinition(clazz.name.substring(clazz.name.lastIndexOf(".")+1).lowerUpper(), BeanDefinitionBuilder.rootBeanDefinition(clazz).beanDefinition)
//}
//fun replace(str:String?):String{
//    if(str==null || str.isEmpty())return str?:""
//    val propertyResolver= applicationContext[PropertyResolver::class]
//    var text:String= str
//    val stringBuilder=StringBuilder()
//    while (true) {
//        val matchResult = text.matching(Regex("\\$\\{"), Regex("}"))
//        if(matchResult==null){
//            stringBuilder.append(text)
//            return stringBuilder.toString()
//        }
//        stringBuilder.append(text.substring(0, matchResult.leftStart))
//        stringBuilder.append(propertyResolver.getProperty(replace(text.substring(matchResult.leftEnd,matchResult.rightStart))))
//        text=text.substring(matchResult.rightEnd)
//    }
//}
//@Configuration
//class SpringContext  {
//    @Autowired
//    lateinit var commonApi: IEurekaApi
//    private val logger = LoggerFactory.getLogger(SpringContext::class.java)
//    @PostConstruct
//    fun init() {
//        var pair = this.commonApi.serverId()
//        identity = Identity(pair.id!!)
//        logger.info("identity init machine code:${pair.id}")
//        thread {
//            while (true) {
//                try {
//                    if (!this.commonApi.heartbeat(pair.token!!)) {
//                        pair = this.commonApi.serverId()
//                        identity = Identity(pair.id!!)
//                        logger.info("identity init machine code:${pair.id}")
//                    }
//                    Thread.sleep(60 * 1000)
//                } catch (e: Exception) {
//                    logger.error("request error", e)
//                }
//            }
//
//        }
//    }
//}