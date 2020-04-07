package com.example.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.Predicate;


public class PicoPlacaService {

    private String result;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm")
            .withZone(ZoneId.systemDefault());

    public String checkPermission(final String dateTime, final String plate) {
        try {
            final char lastDigit = getLastDigit.apply(plate);
            final LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
            result = checkPermission(localDateTime, lastDigit).toString();
            return result;
        } catch (final DateTimeParseException dtex) {
            System.out.println("Format of date is incorrect, use yyyy-MM-dd");
            return "try again";
        }
    }

    
    private final Predicate<Character> monday = lastDigit -> lastDigit.equals(PlateRules.MONDAY.getFirstEndPlate()) || lastDigit.equals(PlateRules.MONDAY.getSecondEndPlate());
    private final Predicate<Character> tuesday = lastDigit -> lastDigit.equals(PlateRules.TUESDAY.getFirstEndPlate()) || lastDigit.equals(PlateRules.TUESDAY.getSecondEndPlate());
    private final Predicate<Character> wednesday = lastDigit -> lastDigit.equals(PlateRules.WEDNESDAY.getFirstEndPlate()) || lastDigit.equals(PlateRules.WEDNESDAY.getSecondEndPlate());
    private final Predicate<Character> thursday = lastDigit -> lastDigit.equals(PlateRules.THURSDAY.getFirstEndPlate()) || lastDigit.equals(PlateRules.THURSDAY.getSecondEndPlate());
    private final Predicate<Character> friday = lastDigit -> lastDigit.equals(PlateRules.FRIDAY.getFirstEndPlate()) || lastDigit.equals(PlateRules.FRIDAY.getSecondEndPlate());

    private final Predicate<LocalDateTime> isHourPermited = dateTime -> {


        final LocalDateTime startMorningRestriction = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(),
                dateTime.getDayOfMonth(), HourRules.MORNING_START.getHour(), HourRules.MORNING_START.getMinute(), 0);
        final LocalDateTime endMorningRestriction = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(),
                dateTime.getDayOfMonth(), HourRules.MORNING_END.getHour(), HourRules.MORNING_END.getMinute(), 0);

        final LocalDateTime startEveningRestriction = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(),
                dateTime.getDayOfMonth(), HourRules.EVENING_START.getHour(), HourRules.EVENING_START.getMinute(), 0);
        final LocalDateTime endEveningRestriction = LocalDateTime.of(dateTime.getYear(), dateTime.getMonth(),
                dateTime.getDayOfMonth(), HourRules.EVENING_END.getHour(), HourRules.EVENING_END.getMinute(), 0);

        if (dateTime.isAfter(startMorningRestriction) && dateTime.isBefore(endMorningRestriction)) {
            return false;
        } else if (dateTime.isAfter(startEveningRestriction) && dateTime.isBefore(endEveningRestriction)) {
            return false;
        } else {
            return true;
        }
    };

    private Boolean checkPermission(final LocalDateTime dateTime, final Character lastDigitPlate) {

        final String dayOfWeek = dateTime.getDayOfWeek().toString();
        switch (dayOfWeek) {
            case "MONDAY":
                if (monday.negate().test(lastDigitPlate))
                    return isHourPermited.test(dateTime);
                else
                    return true;
            case "TUESDAY":
                if (tuesday.test(lastDigitPlate))
                    return isHourPermited.test(dateTime);
                else
                    return true;
            case "WEDNESDAY":
                if (wednesday.test(lastDigitPlate))
                    return isHourPermited.test(dateTime);
                else
                    return true;
            case "THURSDAY":
                if (thursday.test(lastDigitPlate))
                    return isHourPermited.test(dateTime);
                else
                    return true;
            case "FRIDAY":
                if (friday.test(lastDigitPlate))
                    return isHourPermited.test(dateTime);
                else
                    return true;
            default:
                return Boolean.TRUE;
        }
    }

    private final Function<String, Character> getLastDigit = plate -> {
        final IntStream is = plate.chars();
        final Stream<Character> characterStream = is.mapToObj(c -> (char) c);
        final Character[] plateArray = characterStream.toArray(Character[]::new);
        final char lastChar = plate.charAt((plateArray.length - 1));
        return lastChar;
    };

	public String getResult() {
		return result;
	}
}