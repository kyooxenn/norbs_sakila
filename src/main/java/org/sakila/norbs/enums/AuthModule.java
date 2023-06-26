package org.sakila.norbs.enums;

import lombok.Getter;

// --  0 board(info]
// --  1 report(composit, ad, game, player, finance, bet, deposit, withdraw, operation, finance_player]
// --  2 company(list]
// --  3 agent(list, permissions]
// --  4 player(players, duplicate, level, rebate, block]
// --  5 tag(tagged, management]
// --  6 bets(yf, third]
// --  7 promotion(category, activity]
// --  8 payment(online, manual_save, offline, jiama, manual_deduct, withdraw, compensate, recharge_agent, channel_sort]
// --  9 finance(turnover, bag, deposited, withdraw, operations, set_salary, pay_salary, set_dividend, pay_dividend]
// -- 10 accounts(sub_account, scope]
// -- 11 website(custservice, appearance, domain, apps, modules, white_list, horn]
// -- 12 custservice(announcementTH, announcement, tickets, mail, notic, sms]
// -- 13 journal(operation, login]
@Getter
public enum AuthModule {

    BOARD__INFO(0, 0, "guanlikanban"),

    REPORT__COMPOSIT(1, 0, "zhonghebaobiao"),
    REPORT__AD(1, 1, "tuiguangbaobiao"),
    REPORT__GAME(1, 2, "youxibaobiao"),
    REPORT__PLAYER(1, 3, "wanjiabaobiao"),
    REPORT__FINANCE(1, 4, "caiwubaobiao"),
    REPORT__BET(1, 5, "duizhangbaobiao"),
    REPORT__DEPOSIT(1, 6, "congzhibaobiao"),
    REPORT__WITHDRAW(1, 7, "tixianbaobiao"),
    REPORT__OPERATION(1, 8, "yunyingbaobiao"),
    REPORT__FINANCE_PLAYER(1, 9, "wanjiazhangmubaobiao"),
    REPORT__LANDINGPAGE(1, 10, "luodiyetongji"),
    REPORT__LTV(1, 11, "ltvbaobiao"),
    REPORT__BANKMERCHANT(1, 12, "yinshangbaobiao"),

    COMPANY__LIST(2, 0, "yunyingshangguanli"),

    AGENT__LIST(3, 0, "daililiebiao"),
    AGENT__PERMISSIONS(3, 1, "quanxianmoban"),
    AGENT__BANK_MERCHANT(3, 2, "yinshangguanli"),

    PLAYER__PLAYERS(4, 0, "wanjialiebiao"),
    PLAYER__DUPLICATE(4, 1, "chongfuwanjia"),
    PLAYER__LEVEL(4, 2, "dengjishezhi"),
    PLAYER__REBATE(4, 3, "ximabili"),
    PLAYER__BLOCK(4, 4, "wanjiafenghao"),
    /*tab页*/
    PLAYER__PLAYERS_GAMES(4, 5, "wanjialiebiao_youxijilu"),
    PLAYER__PLAYERS_TURNOVER(4, 6, "wanjialiebiao_zijinliushui"),
    PLAYER__PLAYERS_BAGS(4, 7, "wanjialiebiao_beibaoliushui"),
    PLAYER__PLAYERS_DEPOSITED(4, 8, "wanjialiebiao_chongzhijilu"),


    TAG__TAGGED(5, 0, "yibiaoqianyonghu"),
    TAG__MANAGEMENT(5, 1, "biaoqianguanli"),

    BETS__YF(6, 0, "benzhanyouxi"),
    BETS__THIRD(6, 1, "disanfangyouxi"),
    BETS__HASH(6, 2, "hashyouxi"),

    PROMOTION__NEW_ACTIVITY(7, 0, "xinhuodongguanli"),
    PROMOTION__NEW_NOTICE(7, 1, "xingonggaoguanli"),
    PROMOTION__NEW_TASK(7, 2, "xinrenwuguanli"),
    PROMOTION__WORKORDER_MANAGE(7, 3, "gongdanguanli"),

    PAYMENT__ONLINE(8, 0, "zaixianzhifu"),
    PAYMENT__MANUAL_SAVE(8, 1, "rengongchongzhi"),
    PAYMENT__OFFLINE(8, 2, ""),
    PAYMENT__JIAMA(8, 3, "tiandancunkuan"),
    PAYMENT__MANUAL_DEDUCT(8, 4, "rengongkoukuan"),
    PAYMENT__WITHDRAW(8, 5, "tixianguanli"),
    PAYMENT__COMPENSATE(8, 6, "buchangyue"),
    PAYMENT__RECHARGE_AGENT(8, 7, ""),
    PAYMENT__CHANNEL_SORT(8, 8, "zhifuleibie"),
    PAYMENT__BANK_PLAYER(8, 9, "zhuanzhangguanli"),
    PAYMENT__BANKINFO(8, 10, "yinhangweihu"),
    PAYMENT__WITHDRAWCONFIG(8, 11, "tixianshezhi"),

    FINANCE__TURNOVER(9, 0, "zijinliushui"),
    FINANCE__BAG(9, 1, "beibaoliushui"),
    FINANCE__DEPOSITED(9, 2, "wanjiachongzhi"),
    FINANCE__WITHDRAW(9, 3, "wanjiatixian"),
    FINANCE__OPERATIONS(9, 4, "yuetiaozhengjilu"),
    FINANCE__SET_SALARY(9, 5, "gongzishezhi"),
    FINANCE__PAY_SALARY(9, 6, ""),
    FINANCE__SET_DIVIDEND(9, 7, ""),
    FINANCE__PAY_DIVIDEND(9, 8, ""),

    ACCOUNTS__SUB_ACCOUNT(10, 0, "zizhanghao"),
    ACCOUNTS__SCOPE(10, 1, "jueshe"),

    WEBSITE__CUSTSERVICE(11, 0, "kefuguanli"),
    WEBSITE__APPEARANCE(11, 1, "wanzhangshezhi"),
    WEBSITE__DOMAIN(11, 2, "yumingguanli"),
    WEBSITE__APPS(11, 3, "yingyongshezhi"),
    WEBSITE__MODULES(11, 4, ""),
    WEBSITE__WHITE_LIST(11, 5, ""),
    WEBSITE__HORN(11, 6, "paomadeng"),

    CUSTSERVICE__ANNOUNCEMENT_TH(12, 0, "tianhaogonggao"),
    CUSTSERVICE__ANNOUNCEMENT(12, 1, "wanzhangonggao"),
    CUSTSERVICE__TICKETS(12, 2, "yonghufankui"),
    CUSTSERVICE__MAIL(12, 3, "youjianguanli"),
    CUSTSERVICE__NOTIC(12, 4, "tanchuanggonggao"),
    CUSTSERVICE__SMS(12, 5, "duanxinguanli"),
    CUSTSERVICE__CASHWINDOW(12, 6, "tanchuangguanli"),

    JOURNAL__OPERATION(13, 0, "caozuorizhi"),
    JOURNAL__LOGIN(13, 1, "denglurizhi"),

    SUBCONTROL_ROOM_MONITORING(14, 0, "fangjianjiankong"),
    SUBCONTROL_PURSUIT(14, 1, "zhuishaguanli"),
    SUBCONTROL_PLAY_SETTING(14, 2, "peiwanshezhi"),
    SUBCONTROL_SUPER_BLACKLIST(14, 3, "chaojiheimingdan"),
    SUBCONTROL_PROFIT_RANKING(14, 4, "leijiyinglipaihangbang"),
    SUBCONTROL_ABLINE_RECORD(14, 5, "zhuishaguanli"),

    HOME_PAGE(15, 0, "shouye"),

    SYSTEMSET__MENU(16, 0, "caidanlanguanli"),
    SYSTEMSET__ACCOUNT(16, 1, "zhanghaoguanli"),
    SYSTEMSET__ROLE(16, 2, "jueseguanli"),
    SYSTEMSET__DICT(16, 3, "shujuzhidian"),
    SYSTEMSET__AGENTDICT(16, 4, "dailishujuzhidian"),
    SYSTEMSET__OPERLOG(16, 5, "caozuorizhi"),
    SYSTEMSET__LOGINLOG(16, 6, "denglurizhi"),
    SYSTEMSET__WELFAREACTIONTYPE(16, 7, "fuliguanli"),
    SYSTEMSET__CURRENCYEXCHANGERATE(16, 8, "bizhonghuilv"),
    SYSTEMSET__PYTHONMANAGE(16, 9, "pythonguanli"),

    MERCHANT_ACCOUNT_LIST(17, 0, "shanghuzhanghaoguanli"),
    MERCHANT_EMAIL_LIST(17, 1, "shanghuyoujianguanli"),

    DATAANALYSIS_BASE_LIST(18, 0, "jibenshujufenxi"),

    GAMES_CATEGORY_SUPER(19, 0, "youxifenleichaoguan"),
    GAMES_CATEGORY_COMPANY(19, 1, "youxifenleizongdai"),
    GAMES_PLATINFO_SUPER(19, 2, "youxipingtaichaoguan"),
    GAMES_PLATINFO_COMPANY(19, 3, "youxipingtaizongdai"),
    GAMES_CONFIG_SUPER(19, 4, "youxipeizhichaoguan"),
    GAMES_CONFIG_COMPANY(19, 5, "youxipeizhizongdai"),
    GAMES_TYPE(19, 6, "youxileixing"),
    GAMES_CATEGORY_PLATINFO(19, 7, "youxifenleixiapingtai"),
    GAMES_SWITCH(19, 8, "youxikaiguan"),
    GAMES_RTP(19, 9, "rtpshezhi"),
    GAMES_ROOM(19, 10, "youxifangjianguanli"),

    USDT_DEPOSIT(20, 0, "yonghuchongtijilu"),
    USDT_ACCOUNT(20, 1, "dizhichaxun"),
    USDT_MERCHANT(20, 2, "usdtshanghu"),



    ;

    private final int mainIndex;
    private final int subIndex;
    private final String code;

    AuthModule(int mainIndex, int subIndex, String code) {
        this.mainIndex = mainIndex;
        this.subIndex = subIndex;
        this.code = code;
    }
}
