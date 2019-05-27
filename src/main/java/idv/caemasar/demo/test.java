package idv.caemasar.demo;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * test
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-01-18
 */
public class test {
    public static void main(String[] args) throws Exception {
//        FFmpegFrameGrabber ff = new FFmpegFrameGrabber("D:\\桌面\\入职训练\\SOA开发教程视频\\1.总体介绍\\JEESP总体介绍.mp4");
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber("D:\\桌面\\bsc\\ceshi.mp3");
        Java2DFrameConverter converter = new Java2DFrameConverter();
        ff.start();
        System.out.println(ff.getImageHeight());
        System.out.println(ff.getImageWidth());
        System.out.println(ff.getLengthInAudioFrames());
        System.out.println(ff.getLengthInVideoFrames());
        System.out.println(ff.getLengthInFrames());
        System.out.println(ff.getLengthInTime()/1000);
        long m = ff.getLengthInTime();
        System.out.println(formatLongTime(m/1000));
        ff.stop();
    }
    public static String formatLongTime(long mss) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//这里想要只保留分秒可以写成"mm:ss"
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(mss);
        System.out.println(hms);
        return hms;
    }
}
