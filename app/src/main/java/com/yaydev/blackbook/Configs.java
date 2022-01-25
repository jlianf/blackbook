package com.yaydev.blackbook;

import android.app.Activity;

import com.yaydev.blackbook.helper.Characters;
import com.yaydev.blackbook.helper.ErrorMassage;
import com.yaydev.blackbook.helper.ErrorTitle;
import com.yaydev.blackbook.helper.I_Want;
import com.yaydev.blackbook.helper.ShareMessage;
import com.yaydev.blackbook.helper.TitleStyle;
import com.yaydev.blackbook.model.WebPage;

import java.util.ArrayList;
import java.util.List;

public class Configs {

    public static final int Horizontal = 0;
    public static final int Circular = 1;

    public static final int Bottom = 0;
    public static final int Center = 1;

    public static final boolean No = false;
    public static final boolean Yes = true;

    private Activity context;
    private int loadingStyle;
    private int color;
    private int toolBarColor;
    private int toolBarIconColor;
    private int titleColor;
    private int slidingTitleColor;
    private int slidingDescColor;
    private int slidingIcon;
    private int errorCharacter;
    private int downloadStyle;
    private String errorTitle;
    private String errorMessage;
    private String titleStyle;
    private String shareText;
    private String slidingTitle;
    private String slidingDesc;
    private boolean fullscreen;
    private String support;
    private String location;
    private String phone;
    private int splashIcon;

    public Configs(Activity context) {
        this.context = context;

        Do_you_want_to_enable_fullscreen(Yes);

        Splash_screen_icon(R.drawable.yogaweb);

        What_is_the_color_you_want(I_Want.Red);

        What_is_the_color_you_want_for_the_toolbar(I_Want.White);

        What_is_the_color_you_want_for_the_toolbar_icons(I_Want.Black);

        What_is_the_title_style_you_want(TitleStyle.Roboto);

        What_is_the_title_color_you_want(I_Want.Red);

        Sliding_view_icon(R.drawable.product);

        Sliding_view_title("Freecode");

        Sliding_view_title_color(I_Want.White);

        Sliding_view_description("Dynamic WebView app fully customizable.");

        Sliding_view_description_color(I_Want.White);

        What_is_the_loading_style_you_want(Horizontal);

        What_is_the_download_style_you_want(Bottom);

        Choose_your_connection_error_character(Characters.Six);

        Your_connection_error_title(ErrorTitle.Style4);

        Your_connection_error_message(ErrorMassage.Style5);

        Choose_your_share_message(ShareMessage.Default);

        What_is_your_support_email_address("mr.Raghav.Apphelp283@gmail.com");

        What_is_your_location_address("1600 Amphitheatre Parkway, Mountain+View, California");

        What_is_your_business_phone_number("+1712-800-0770");

    }

    public List<WebPage> getWebPages() {
        List<WebPage> pages = new ArrayList<>();

        pages.add(new WebPage(0, R.drawable.ic_home, "Home", "https://freecodandroidstudio.blogspot.com"));
        pages.add(new WebPage(1, R.drawable.ic_heart, "Features", "https://www.youtube.com/channel/UCPa8a9lQu1fSms06GOmcTqg"));
        pages.add(new WebPage(2, R.drawable.ic_explore, "Explore", " https://t.me/zzcode_free_source_code"));
        pages.add(new WebPage(3, R.drawable.ic_about, "About", "https://freecode.com/about/"));
        pages.add(new WebPage(4, R.drawable.ic_shield, "Terms of Use", "https://freecode.com/privacy/"));

        return pages;
    }

    public List<WebPage> getInfoPages() {
        List<WebPage> pages = new ArrayList<>();

        pages.add(new WebPage(0, R.drawable.ic_email, "Support", support));
        pages.add(new WebPage(1, R.drawable.ic_pin, "Location", "geo:0,0?q=" + location));
        pages.add(new WebPage(2, R.drawable.ic_telephone, "Contact us", "tel:" + phone));

        return pages;
    }

    public List<WebPage> getSocialPages() {
        List<WebPage> pages = new ArrayList<>();

        pages.add(new WebPage(0, R.drawable.ic_facebook, "Facebook", "https://www.facebook.com/envato"));
        pages.add(new WebPage(1, R.drawable.ic_instagram, "Instagram", "https://www.instagram.com/envato/"));
        pages.add(new WebPage(2, R.drawable.ic_twitter, "Twitter", "https://twitter.com/envato"));
        pages.add(new WebPage(3, R.drawable.ic_pinterest, "Pinterest", "https://www.pinterest.com/envato/_created/"));

        pages.add(new WebPage(4, R.drawable.ic_pin, "your title", "your link"));

        return pages;
    }

    public int getSplashIcon() {
        return splashIcon;
    }

    private void Splash_screen_icon(int iconS) {
        splashIcon = iconS;
    }

    public int getLoadingStyle() {
        return loadingStyle;
    }

    public int getColor() {
        return color;
    }

    public int getToolBarColor() {
        return toolBarColor;
    }

    public int getToolBarIconColor() {
        return toolBarIconColor;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public String getTitleStyle() {
        return titleStyle;
    }

    public String getShareText() {
        return shareText;
    }

    public String getSlidingTitle() {
        return slidingTitle;
    }

    public String getSlidingDesc() {
        return slidingDesc;
    }

    public int getDownloadStyle() {
        return downloadStyle;
    }

    public int getSlidingDescColor() {
        return slidingDescColor;
    }

    public int getSlidingTitleColor() {
        return slidingTitleColor;
    }

    public int getSlidingIcon() {
        return slidingIcon;
    }

    public int getErrorCharacter() {
        return errorCharacter;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    private void What_is_the_color_you_want(int color) {
        this.color = color;
    }

    private void What_is_the_color_you_want_for_the_toolbar(int color) {
        this.toolBarColor = color;
    }

    private void What_is_the_color_you_want_for_the_toolbar_icons(int color) {
        this.toolBarIconColor = color;
    }

    private void What_is_the_title_style_you_want(String style) {
        this.titleStyle = style;
    }

    private void What_is_the_title_color_you_want(int color) {
        this.titleColor = color;
    }

    private void Choose_your_share_message(String text) {
        this.shareText = text;
    }

    private void Sliding_view_title(String text) {
        this.slidingTitle = text;
    }

    private void Sliding_view_title_color(int color) {
        this.slidingTitleColor = color;
    }

    private void Sliding_view_description(String text) {
        this.slidingDesc = text;
    }

    private void Sliding_view_description_color(int color) {
        this.slidingDescColor = color;
    }

    private void Sliding_view_icon(int icon) {
        this.slidingIcon = icon;
    }

    private void What_is_the_loading_style_you_want(int style) {
        loadingStyle = style;
    }

    private void Choose_your_connection_error_character(int character) {
        errorCharacter = character;
    }

    private void Your_connection_error_message(String message) {
        errorMessage = message;
    }

    private void Your_connection_error_title(String title) {
        errorTitle = title;
    }

    private void Do_you_want_to_enable_fullscreen(boolean answer) {
        fullscreen = answer;
    }

    private void What_is_your_support_email_address(String supportEmail) {
        this.support = supportEmail;
    }

    private void What_is_your_location_address(String location) {
        this.location = location;
    }

    private void What_is_your_business_phone_number(String phone) {
        this.phone = phone;
    }

    private void What_is_the_download_style_you_want(int s) {
        downloadStyle = s;
    }
}
