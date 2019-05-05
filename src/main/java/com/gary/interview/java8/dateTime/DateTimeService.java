/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.gary.interview.java8.dateTime;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * 0. Java8 新时间日期API(线程安全)
 *  java.time
 * 		- Duration, Period
 * 		- Instant, L`ocalDate, LocalTime, LocalDateTime
 *		- Month(JANUARY...December), DayOfWeek(MONDAY...SUNDAY)
 * 		- ZoneId(eg: Asia/Shanghai, America/Los_Angeles)
 *		- OffsetTime, OffsetDateTime, ZoneOffset (偏移量)
 *
 *  java.time.chrono包 - 时间日期的特殊格式
 *
 *  java.time.format包 - 格式化
 *		- DateTimeFormatter
 *			- BASIC_ISO_DATE		'20111203'
 *			- ISO_LOCAL_DATE		'2011-12-03'
 *			- ISO_LOCAL_TIME		'10:15:30'
 *			- ISO_LOCAL_DATE_TIME	'2011-12-03T10:15:30'
 *			- ISO_ZONED_DATE_TIME	'2011-12-03T10:15:30+01:00[Europe/Paris]'
 *			- ISO_DATE_TIME 		'2011-12-03T10:15:30+01:00[Europe/Paris]'
 *			- ISO_WEEK_DATE 		'2012-W48-6'
 *			- ISO_INSTANT 			'2011-12-03T10:15:30Z'
 *			- RFC_1123_DATE_TIME 	'Tue, 3 Jun 2008 11:05:30 GMT'
 *
 *  java.time.temporal -
 *		- TemporalAmount, TemporalAdjuster(TemporalAdjusters)
 *		- ChronoField
 *			- DAY_OF_MONTH, DAY_OF_WEEK, DAY_OF_YEAR
 *			- HOUR_OF_AMPM, HOUR_OF_DAY, MINUTE_OF_HOUR
 * 			- MONTH_OF_YEAR, YEAR
 *		- ChronoUnit
 *	        - MILLIS, SECONDS, MINUTES, HOURS, DAYS, MONTHS, YEARS, DECADES, CENTURIES
 *
 *  java.time.zone - 时区
 *
 *
 *  1. 时间日期类
 *      1.1. 人读的 :
 *          LocalDate, LocalTime, LocalDateTime
 *          (三者使用方式一样)
 *
 *          特点:
 *          -   不可变的对象
 *          -   分别使用ISO-8601日历系统的日期,时间,日期和时间
 *
 *          常用方法:
 *
 *          - 创建
 *          - now()
 *              : 静态方法, 根据当前时间创建对象
 *          - of()
 *              : 静态方法, 根据指定日期/时间创建对象
 *
 *          - 加减
 *          - plusDays, plusWeeks, plusMonths, plusYears
 *              : 向当前LocalDate对象添加几天, 周, 月, 年
 *          - minusDays, minusWeeks, minusMonths, minusYears
 *              : 从当前LocalDate对象减去几天, 周, 月, 年
 *          - plus, minus
 *              : 添加或减去一个Duration或Period
 *
 *          - 赋值
 *            withDayOfMonth, withDayOfYear, withMonth, withYear
 *              : 将月份天数, 年份天数, 月份, 年份修改为指定的值并返回新的LocalDate对象
 *
 *          - 获取
 *          - getDayOfMonth
 *              : 获取月份天数(1 - 31)
 *          - getDayOfYear
 *              : 获取年份天数(1 - 366)
 *          - getDayOfWeek
 *              : 获得星期几(返回一个DayOfWeek枚举值)
 *          - getMonth
 *              : 获得月份, 返回一个Month枚举值
 *          - getMonthValue
 *              : 获得月份(1-12)
 *          - getYear
 *              : 获得年份
 *
 *          - until
 *              : 获得两个日期之间的Period对象,或者指定Chrono Units的数字
 *          - isBefore, isAfter
 *              : 比较两个LocalDate
 *          - isLeapYear
 *              : 判断是否是闰年
 *
 *      1.2. 机器读的 :
 *          Instant 时间戳
 *
 *          特点:
 *          - 以Unix元年(UTC时区1970年1月1日00:00:00)开始所经历的毫秒值进行运算
 *
 *  2. 时间间隔
 *      Duration : 时间间隔
 *          - between(xx, yy)
 *          - toHours(), toDays(), toMinutes(), toMillis()
 *      Period : 日期间隔
 *          - between(xx, yy)
 *          - getDays(), getMonths(), getYears(), toTotalMonth()
 *      Offset - 偏移量
 *
 *  3. 日期操纵 : localDataTime.with(TemporalAdjuster adj)
 *      TemporalAdjuster : 时间校正器, 接口
 *      TemporalAdjusters : 通过静态方法提供大量常用的TemporalAdjuster的实现
 *
 *  4. 解析与格式化
 *      java.time.format.DateTimeFormatter
 *          - 预定义的标准格式
 *          - 语言环境相关的格式
 *          - 自定义的格式
 *          LocalDate date = LocalDate.now();
 *          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
 *          String text = date.format(formatter);
 *          LocalDate parsedDate = LocalDate.parse(text, formatter);
 *
 *  5. 时区的处理
 *      ZonedDate, ZonedTime, ZonedDateTime
 *      - 每个时区对应着ID, 地区ID都为"{区域}/{城市}"的格式, eg: Asia/Shanghai
 *
 *      ZoneId 时区信息
 *          - getAvailableZonedIds()
 *              : 获取所有时区信息
 *          - of(id)
 *              : 用指定的时区信息获取ZoneId对象
 *
 *  6. 与传统日期处理的转换
 *      - java.time.Instant <=> java.util.Date
 *      Date.from(instant)
 *      date.toInstant()
 *
 *      - java.time.Instant <=> java.sql.Timestamp
 *      Timestamp.from(instant)
 *      timestamp.toInstant()
 *
 *      - java.time.ZonedDateTime <=> java.util.GregorianCalendar
 *      GregorianCalendar.from(zonedDateTim e)
 *      cal.toZonedDateTime()
 *
 *      - java.time.LocalDate <=> java.sql.Time
 *      Date.valueOf(localDate)
 *      date.toLocalDate()
 *
 *      - java.time.LocalTime <=> java.sql.Time
 *      Date.valueOf(localDate)
 *      date.toLocalTime()
 *
 *      - java.time.LocalDateTime <=> java.sql.Timestamp
 *      Timestamp.valueOf(localDateTime)
 *      timestamp.toLocalDateTime()
 *
 *      - java.time.ZoneId <=> java.util.TimeZone
 *      Timezone.getTimeZone(id)
 *      timeZone.toZoneId()
 *
 *      - java.time.format.DateTimeFormatter <=> java.text.DateFormat
 *      formatter.toFormat()
 *      无
 *
 */
public class DateTimeService {


public void localDateTimeTest(){
    LocalDate nowDate = LocalDate.now();
    LocalTime nowTime = LocalTime.now();
    LocalDateTime nowDateTime = LocalDateTime.now();

    System.out.println("Now : ");
    System.out.println(nowDate);
    System.out.println(nowTime);
    System.out.println(nowDateTime);
    System.out.println("=================");

    LocalDate birthDate = LocalDate.of(1991, Month.AUGUST, 26);
    LocalTime birthTime = LocalTime.of(20, 30, 10);
    LocalDateTime birthDateTime = LocalDateTime.of(birthDate, birthTime);
    System.out.println("Birth : ");
    System.out.println(birthDate);
    System.out.println(birthTime);
    System.out.println(birthDateTime);
    System.out.println("==================");

    LocalDate afterBirthDate10Days = birthDate.plusDays(10);
    Duration duration = Duration.ofDays(100);
    LocalTime afterBirth100Days = birthTime.plus(duration);
    LocalDateTime beforeBirthDateTime10Years = birthDateTime.minusYears(10);
    LocalDateTime beforeBirthDateTime10YearsPlus2Month = beforeBirthDateTime10Years.plusMonths(2);

    System.out.println("After / before :");
    System.out.println("afterBirthDate10Days = " + afterBirthDate10Days);
    System.out.println("afterBirth100Days = " + afterBirth100Days);
    System.out.println("beforeBirthDateTime10Years = " + beforeBirthDateTime10Years);
    System.out.println("beforeBirthDateTime10YearsPlus2Month = " + beforeBirthDateTime10YearsPlus2Month);
    System.out.println("==================");

    LocalDateTime birthDateTimeResetDay = birthDateTime.withDayOfMonth(10);
    LocalDateTime birthDateTimeResetHour = birthDateTime.withHour(10);
    System.out.println("Reset");
    System.out.println("birthDateTimeResetDay = " + birthDateTimeResetDay);
    System.out.println("birthDateTimeResetHour = " + birthDateTimeResetHour);
    System.out.println("==================");

    System.out.println("Get second, minute, hour, day, month year from [" + birthDateTime + "]");
    System.out.println("second : " + birthDateTime.getSecond());
    System.out.println("minute : " + birthDateTime.getMinute());
    System.out.println("hour : " + birthDateTime.getHour());
    System.out.println("day of week : " + birthDateTime.getDayOfWeek());
    System.out.println("day of month : " + birthDateTime.getDayOfMonth());
    System.out.println("day of year : " + birthDateTime.getDayOfYear());
    System.out.println("month value : " + birthDateTime.getMonthValue());
    System.out.println("month : " + birthDateTime.getMonth());
    System.out.println("year " + birthDateTime.getYear());
    System.out.println("ChronoField.DAY_OF_MONTH : " + birthDateTime.get(ChronoField.DAY_OF_MONTH));
    System.out.println("==================");

    System.out.println("now the Age is : " + birthDateTime.until(LocalDateTime.now(), ChronoUnit.YEARS));
    System.out.println("birth date is leap year ? " + birthDate.isLeapYear());
    System.out.println("==================");
    LocalDateTime dateA = LocalDateTime.of(2019, 8, 26, 20, 30, 30);
    LocalDateTime dateB = LocalDateTime.of(2010, 3, 12, 6, 45, 5);
    System.out.println("dateA : " + dateA);
    System.out.println("dateB : " + dateB);
    Duration betweenDuration = Duration.between(dateB, dateA);
    System.out.println("birthDateTimeResetHour : ");
    System.out.println("toHours : " + betweenDuration.toHours());
    System.out.println("toDays : " + betweenDuration.toDays());
    System.out.println("toMinutes : " + betweenDuration.toMinutes());
    System.out.println("toMillis : " + betweenDuration.toMillis());
    Period betweenPeriod = Period.between(dateB.toLocalDate(), dateA.toLocalDate());
    System.out.println("betweenPeriod : ");
    System.out.println("getDays : " + betweenPeriod.getDays());
    System.out.println("getMonths : " + betweenPeriod.getMonths());
    System.out.println("getYears : " + betweenPeriod.getYears());
    System.out.println("toTotalMonths : " + betweenPeriod.toTotalMonths());


    System.out.println("==================");

    TemporalAdjuster firstDayOfMonthAdjuster = TemporalAdjusters.firstDayOfMonth();
    TemporalAdjuster previousSaturdayAdjuster = TemporalAdjusters.previous(DayOfWeek.SATURDAY);
    TemporalAdjuster dayOfWeekInMonthAdjuster1 = TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.WEDNESDAY);
    TemporalAdjuster dayOfWeekInMonthAdjuster2 = TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.WEDNESDAY);
    TemporalAdjuster dayOfWeekInMonthAdjuster3 = TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.WEDNESDAY);
    System.out.println("["+birthDateTime+"]");
    System.out.println("firstDayOfMonthAdjuster " + birthDateTime.with(firstDayOfMonthAdjuster));
    System.out.println("previousSaturdayAdjuster " + birthDateTime.with(previousSaturdayAdjuster));
    System.out.println("dayOfWeekInMonthAdjuster1 " + birthDateTime.with(dayOfWeekInMonthAdjuster1));
    System.out.println("dayOfWeekInMonthAdjuster2 " + birthDateTime.with(dayOfWeekInMonthAdjuster2));
    System.out.println("dayOfWeekInMonthAdjuster3 " + birthDateTime.with(dayOfWeekInMonthAdjuster3));
    System.out.println("==================");

    System.out.println("["+birthDateTime+"]");
    System.out.println("ISO_DATE_TIME : " + birthDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
    System.out.println("ISO_DATE : " + birthDateTime.format(DateTimeFormatter.ISO_DATE));
    System.out.println("BASIC_ISO_DATE : " + birthDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年mm月dd日-hh时mm分ss秒");
    System.out.println("self formatter : " + birthDateTime.format(formatter));
    System.out.println("==================");

    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
    System.out.println("availableZoneIds : {" + availableZoneIds.stream().collect(Collectors.joining("; "))+"}");
    ZoneId zoneIdGz = ZoneId.of("Asia/Shanghai");
    ZoneId zoneIdLa = ZoneId.of("America/Los_Angeles");
    System.out.println("GZ : " + birthDateTime.atZone(zoneIdGz));
    System.out.println("LA : " + birthDateTime.atZone(zoneIdLa));


}


//以Unix元年(UTC时区1970年1月1日00:00:00)开始所经历的描述进行运算
public void instantTest(){
    Instant now = Instant.now();
    Instant originInstant = Instant.ofEpochSecond(0);
    Instant afterOriginInstant = Instant.ofEpochSecond(3600);
    System.out.println("UTC now = " + now);// UTC时区
    System.out.println("Our timezone now ="+ now.atOffset(ZoneOffset.ofHours(8)));
    System.out.println("originInstant = " + originInstant);
    System.out.println("afterOriginInstant = " + afterOriginInstant);
}


}
