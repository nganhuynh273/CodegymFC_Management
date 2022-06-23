package hpn.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtils {
    public static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    public static final String PASSWORD_REGEX ="^([a-zA-Z0-9]{8,})";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";
    public static final String USERNAME_REGEX = "^[A-Za-z][A-Za-z0-9_]{7,19}$";
    public static final String ADDRESS_REGEX = "^[A-Za-z][A-Za-z0-9_]{7,19}$";
    public static final String MANHANVIENCT_REGEX = "^([CT]*\\d{0,3})$";
    public static final String MANHANVIENHLV_REGEX = "^([HLV]*\\d{0,3})$";

    public static final String GIOITINH_REGEX = "^(Nam)|(Nữ)$";

    public static final String TIME_REGEX = "^([0-2][0-3]:[0-5][0-9])$";



    public static boolean isCT(String maNhanVien) {
        return Pattern.matches(MANHANVIENCT_REGEX, maNhanVien);
    }

    public static boolean isHLV(String maNhanVien) {
        return Pattern.matches(MANHANVIENHLV_REGEX, maNhanVien);
    }
    public static boolean isTime(String gioThiDau) {
        return Pattern.matches(TIME_REGEX, gioThiDau);
    }

    public static boolean isGioitinh(String gioiTinh) {
        return Pattern.matches(GIOITINH_REGEX, gioiTinh);
    }

//    public static boolean isIDStaffValid(String maNhanvien) {
//
//        return Pattern.matches(MANHANVIEN_REGEX, maNhanvien);
//    }

    public static boolean isPasswordValid(String password) {

        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public static boolean isNameValid(String quocTich) {

        return Pattern.matches(NAME_REGEX, quocTich);
    }

    public static boolean isPhoneValid(String phone) {

        return Pattern.matches(PHONE_REGEX, phone);
    }

    public static boolean isEmailValid(String email) {

        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isUsernameValid(String username) {

        return Pattern.matches(USERNAME_REGEX, username);
    }

    public static boolean isAddressValid(String address) {

        return Pattern.matches(ADDRESS_REGEX, address);
    }

    public static boolean isDateValid(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        try {
            LocalDate.parse(convertDate(dateStr), dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static String convertDate(String date) {
        //  23-04-2021 -> 20210423
        String[] array = date.split("-");
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

//    public static long convertDateToMilli(String date) throws ParseException {
//        // 23/04/2021 -> 1619110800000
//        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
//        return date1.getTime();
//    }

//    public static String convertMilliToDate(long millisecond) {
//        // 1619110800000 -> 23/04/2021
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        return dateFormat.format(millisecond);
//    }

}
