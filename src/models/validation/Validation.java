package models.validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Beans.AccountInfo;

public class Validation {

    public static final String romanRegex = "^[A-Za-z]+$";

    //各チェック実行メソッド
    public List<String> doValidation(AccountInfo ai) {
        List<String> errorList = new ArrayList<>();
        inputValidation(ai, errorList);

        if(errorList.size() == 0) {
            otherValidation(ai, errorList);
        }

        return errorList;
    }

    //各項目入力チェック
    public static void inputValidation(AccountInfo accountInfo, List<String> errorList) {

        if(accountInfo.getFirstName() == null || accountInfo.getFirstName().equals("")) {
            errorList.add("姓が入力されていません。");
        }

        if(accountInfo.getLastName() == null || accountInfo.getLastName().equals("")) {
            errorList.add("名が入力されていません。");
        }

        if(accountInfo.getBirthDate() == null || accountInfo.getBirthDate().equals("")) {
            errorList.add("生年月日が入力されていません。");
        }

    }

    //その他整合性チェック
    public static void otherValidation(AccountInfo accountInfo, List<String> errorList) {

        //姓ローマ字入力チェック
        if(!accountInfo.getLastName().matches(romanRegex)) {
            errorList.add("姓は全てローマ字で入力してください。");
        }
        //名ローマ字入力チェック
        if(!accountInfo.getFirstName().matches(romanRegex)) {
            errorList.add("名は全てローマ字で入力してください。");
        }
        //生年月日が未来日じゃないかチェック
        LocalDate currentDate = LocalDate.now();
        LocalDate inputedBirthDate = LocalDate.parse(accountInfo.getBirthDate());

        if(inputedBirthDate.isAfter(currentDate)) {
            errorList.add("入力日付は必ず今日と比較して過去日を指定してください。");
        }
    }
}
