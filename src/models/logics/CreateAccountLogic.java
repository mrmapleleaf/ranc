package models.logics;

import java.util.Random;

import models.Beans.AccountInfo;

public class CreateAccountLogic {

    public String createAccountName(AccountInfo ai) {
        String stringLine = ai.getFirstName() + ai.getLastName() + ai.getBirthDateNum();
        Random random = new Random();
        //桁数を決定(6-12桁でランダム)
        int lengthOfAccountName = random.nextInt(7) + 6;
        //入力された文字列から１文字ずつランダムに取得し、アカウント名を作成
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < lengthOfAccountName; i++) {
            sb.append(stringLine.charAt(random.nextInt(stringLine.length())));
        }

        return sb.toString();
    }
}
