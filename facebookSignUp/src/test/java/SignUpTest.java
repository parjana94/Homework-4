import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SignUpTest {
    @Test
    public void firstTest() {
        open("https://www.facebook.com/");
        SelenideElement regBtn = $(byText("Create new account"));
        SelenideElement firstName = $(byName("firstname"));
        SelenideElement lastName = $(byName("lastname"));
        SelenideElement birthMonth = $("#month");
        SelenideElement birthDay = $("#day");
        SelenideElement birthYear = $("#year");
        SelenideElement gender = $(byAttribute("value", "-1"));
        SelenideElement pronoun = $("#custom_gender_container");
        SelenideElement customGender = $("#custom_gender");
        SelenideElement selectPronoun = $("#preferred_pronoun");
        SelenideElement genderMale = $(byText("Male"));

        regBtn.click();
        firstName.setValue("Beka");
        lastName.setValue("Parjanadze");
        birthMonth.selectOption("Jul");
        birthDay.selectOption("6");
        birthYear.selectOption("1994");
        gender.click();
        pronoun.shouldBe(Condition.visible);
        customGender.shouldBe(Condition.visible);
        selectPronoun.selectOption("He: \"Wish him a happy birthday!\"");
        genderMale.click();
        pronoun.shouldBe(Condition.hidden);
        customGender.shouldBe(Condition.hidden);
        sleep(5000);
    }
}
