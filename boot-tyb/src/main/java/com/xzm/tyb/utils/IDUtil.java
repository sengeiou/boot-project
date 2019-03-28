//package com.xzm.tyb.utils;
//
//import com.wujunshen.core.bean.ID;
//import com.wujunshen.core.service.IdService;
//import com.wujunshen.core.service.impl.IdServiceImpl;
//import org.apache.commons.lang.time.DateFormatUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.Resource;
//
//public class IDUtil {
//
//
//    protected Logger logger = LoggerFactory.getLogger(getClass());
//    private  IDUtil instance;
//
//    private IDUtil() {
//    }
//
//    public  IDUtil getInstance() {
//        if (instance == null) {
//            instance = new IDUtil();
//        }
//        return instance;
//    }
//
//    //   @Resource
////   private  static IdService idService = new IdServiceImpl(23);
//    @Resource
//    private IdService idService;
//
//    //    @GetMapping(value = "/id")
////    @ApiOperation(value = "生成ID", httpMethod = "GET", notes = "成功返回ID", response = long.class)
//    public long genId() {
//
//        return idService.genId();
//    }
//
//
//    //    @PostMapping("/id")
////    @ApiOperation(value = "传入相应参数生成ID", httpMethod = "POST", notes = "成功返回ID", response = long.class)
//    public long makeId(long worker, long time, long sequence) {
//        System.out.println("==");
////        long worker = makeID.getMachine();
////        long time = makeID.getTime();
////        long sequence = makeID.getSeq();
////        logger.info("worker is {}", worker);
////        logger.info("time is {}", time);
////        logger.info("sequence is {}", sequence);
//
//        if (time == -1 || sequence == -1) {
//            throw new IllegalArgumentException("Both time and sequence are required.");
//        }
//
//        return worker == -1
//                ? idService.makeId(time, sequence)
//                : idService.makeId(time, worker, sequence);
//    }
//
//    //    @GetMapping("/id/{id:[0-9]*}")
////    @ApiOperation(
////            value = "对ID进行解析",
////            httpMethod = "GET",
////            notes = "成功返回解析后的ID（json格式）",
////            response = ID.class)
//// @ApiParam(value = "要解析的ID", required = true) @PathVariable("id")
//    public ID explainId(long id) {
//        return idService.expId(id);
//    }
//
//    //    @GetMapping("/time/{time:[0-9]*}")
////    @ApiOperation(
////            value = "对时间戳进行解析",
////            httpMethod = "GET",
////            notes = "成功返回yyyy-MM-dd HH:mm:ss格式的日期时间",
////            response = String.class)
//    public String transTime(long time) {
//        return DateFormatUtils.format(idService.transTime(time), "yyyy-MM-dd HH:mm:ss");
//    }
//
////    @PostMapping("/id")
////    @ApiOperation(value = "传入相应参数生成ID", httpMethod = "POST", notes = "成功返回ID", response = long.class)
////    public long makeId(
////            @ApiParam(value = "传入的相应参数（json格式）", required = true) @RequestBody MakeID makeID) {
////        System.out.println("==");
////        long worker = makeID.getMachine();
////        long time = makeID.getTime();
////        long sequence = makeID.getSeq();
////        logger.info("worker is {}", worker);
////        logger.info("time is {}", time);
////        logger.info("sequence is {}", sequence);
////
////        if (time == -1 || sequence == -1) {
////            throw new IllegalArgumentException("Both time and sequence are required.");
////        }
////
////        return worker == -1
////                ? idService.makeId(time, sequence)
////                : idService.makeId(time, worker, sequence);
////    }
//}
