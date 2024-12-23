package exception;

import java.util.regex.Pattern;

public class InputValidation {
    //이름 확인 - 한글만 가능

    public boolean nameCheck(String name) throws MyException {
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$",name);
        if (!check){
            throw new MyException("※이름은 한글만!");
        }
        return (!check);
    }
    //전화번호 타입 확인(핸드폰)
    public boolean phoneCheck(String phone) throws MyException{
        boolean check = Pattern.matches("^(01[016789]-?\\d{3,4}-?\\d{4})$",phone);
        if (!check){
            throw new MyException("※휴대폰 입력 형식 : [010-XXXX-XXXX]");
        }
        return (!check);
    }

    //나이 입력확인
    public boolean ageCheck(int age) throws MyException{
        if (age < 0 || age >= 120){
            throw new MyException("※나이는 0세부터 120세까지 입니다.");
        }else {
            return false;
        }
    }
    
}
