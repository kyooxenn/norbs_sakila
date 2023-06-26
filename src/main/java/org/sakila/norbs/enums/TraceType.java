package org.sakila.norbs.enums;

import lombok.Getter;

@Getter
public enum TraceType {
    /**
     * 不进行记录
     */
    NONE(-1, "", "", ""),

    /**
     * 跑马灯列表
     */
    LIST_HORN(1000, "网站管理", "跑马灯", "跑马灯列表"),
    /**
     * 跑马灯细节
     */
    DETAIL_HORN(1001, "网站管理", "跑马灯", "跑马灯细节"),
    /**
     * 查询第三方游戏记录
     */
    LIST_THIRD_GAME_LOG(1002, "游戏", "第三方游戏", "查询第三方游戏记录"),
    /**
     * 查询第三方游戏记录细节
     */
    DETAIL_THIRD_GAME_LOG(1003, "游戏", "第三方游戏", "查询第三方游戏记录细节"),
    /**
     * 查询易发主游戏记录
     */
    LIST_MAIN_GAME_LOG(1004, "游戏", "本站游戏", "查询易发主游戏记录"),
    /**
     * 查询易发主游戏记录细节
     */
    DETAIL_MAIN_GAME_LOG(1005, "游戏", "本站游戏", "查询易发主游戏记录细节"),
    /**
     * 查询易发主游戏记录牌桌记录
     */
    DESK_MAIN_GAME_LOG(1006, "游戏", "本站游戏", "查询易发主游戏记录牌桌记录"),
    /**
     * Domain 列表
     */
    LIST_DOMAIN(1007, "网站管理", "域名管理", "Domain 列表"),
    /**
     * 未处理请求列表
     */
    LIST_TODO(1008, "", "", "未处理请求列表"),
    /**  取得未处理存/提款请求数 */
//	GET_BEEP(1009, "", "", ""),
    /**
     * 客服连结列表
     */
    LIST_CUST_SERV_URL(1010, "网站管理", "客服管理", "客服连结列表"),
    /**
     * 增加客服连结
     */
    ADD_CUST_SERV_URL(1011, "网站管理", "客服管理", "增加客服连结"),
    /**
     * 切换客服连结状态
     */
    SWITCH_CUST_SERV_URL(1012, "网站管理", "客服管理", "切换客服连结状态"),
    /**
     * 编辑客服连结明细
     */
    EDIT_CUST_SERV_URL(1013, "网站管理", "客服管理", "编辑客服连结明细"),
    /**
     * 删除客服连结
     */
    DELETE_CUST_SERV_URL(1014, "网站管理", "客服管理", "删除客服连结"),
    /**
     * 查询可设置的国家清单
     */
    LIST_CTRL_COUNTRY(1015, "运营商管理", "运营商管理", "查询可设置的国家清单"),
    /**
     * 查询允许的玩家所在国家
     */
    LIST_ALLOW_COUNTRY(1016, "运营商管理", "运营商管理", "查询允许的玩家所在国家"),
    /**
     * 查询允许登入 BO 的运营商 ip
     */
    LIST_ALLOW_COMPANY_IPS(1017, "运营商管理", "运营商管理", "查询允许登入 BO 的运营商 ip"),
    /**
     * 创建运营商
     */
    CREATE_COMPANY(1018, "运营商管理", "运营商管理", "创建运营商"),
    /**
     * 列出所有运营商
     */
    LIST_COMPANY(1019, "运营商管理", "运营商管理", "列出所有运营商"),
    /**
     * 查询维护状态
     */
    GET_MAINTAIN_STATUS(1020, "运营商管理", "运营商管理", "查询维护状态"),
    /**
     * 列出所有运营商
     */
    LIST_COMPANY_LITE(1021, "运营商管理", "运营商管理", "列出所有运营商"),
    /**
     * 列出运营商可配置的游戏选项
     */
    LIST_AVAIL_GAMES(1022, "运营商管理", "运营商管理", "列出运营商可配置的游戏选项"),
    /**
     * 列出运营商已配置的可用游戏
     */
    LIST_CONFIGURED_GAMES(1023, "运营商管理", "运营商管理", "列出运营商已配置的可用游戏"),
    /**
     * 列出运营商已配置的可用游戏細節
     */
    DETAIL_CONFIGURED_GAME(1024, "运营商管理", "运营商管理", "列出运营商已配置的可用游戏细节"),
    /**
     * 运营商上传图片
     */
    UPLOAD_IMG_TO_TH(1025, "运营商管理", "运营商管理", "运营商上传图片"),
    /**
     * 银行列表
     */
    GET_BANK_LIST(1026, "", "", "银行列表"),
    /**
     * 省份列表
     */
    GET_PROVINCE_LIST(1027, "", "", "省份列表"),
    /**
     * 城市列表
     */
    GET_CITY_LIST(1028, "", "", "城市列表"),
    /**
     * 分行列表
     */
    GET_BRANCH_LIST(1029, "", "", "分行列表"),
    /**
     * 查询銀行流水记录
     */
    LIST_BANK_RECORDS(1030, "财务管理", "资金流水", "查询银行流水记录"),
    /**
     * 查询团队銀行流水记录
     */
    LIST_BANK_RECORDS_BY_TEAM(1031, "财务管理", "资金流水", "查询团队銀行流水记录"),
    /**
     * 查询背包流水记录
     */
    LIST_BAG_RECORDS(1032, "财务管理", "背包流水", "查询背包流水记录"),
    /**
     * 查询团队背包流水记录
     */
    LIST_BAG_RECORDS_BY_TEAM(1033, "财务管理", "背包流水", "查询团队背包流水记录"),
    /**
     * 登出
     */
    LOG_OUT(1034, "", "", "登出"),
    /**
     * 刷新登入状态
     */
    RECURRENT(1035, "", "", "刷新登入状态"),
    /**
     * 查询 BO 登入记录
     */
    LIST_LOGIN_LOG(1036, "日志", "登录日志", "查询 BO 登入记录"),
    /**
     * 查询玩家等级设置
     */
    GET_PLAYER_LV_SETTINGS(1037, "玩家管理", "等级设置", "查询玩家等级设置"),
    /**
     * 查询玩家洗码设置
     */
    GET_PLAYER_REBATE_SETTING(1038, "玩家管理", "洗码比例", "查询玩家洗码设置"),
    /**
     * 查询邮件发送记录
     */
    LIST_MAIL_HISTORY(1039, "客户服务", "邮件管理", "查询邮件发送记录"),
    /**
     * 弹窗公告列表
     */
    LIST_NOTIC(1040, "客户服务", "弹窗公告", "弹窗公告列表"),
    /**
     * 弹窗公告细节
     */
    DETAIL_NOTIC(1041, "客户服务", "弹窗公告", "弹窗公告细节"),
    /**
     * 天豪后台可用功能列表
     */
    GET_UI_RES(1042, "", "", "天豪后台可用功能列表"),
    /**
     * 取得天豪后台功能网址
     */
    GET_TH_UI_URL(1043, "", "", "取得天豪后台功能网址"),
    /**
     * 查看天豪充值渠道
     */
    LIST_DEPOSIT_CHL(1044, "支付管理", "在线支付", "查看天豪充值渠道"),
    /**
     * 查看天豪加码充值渠道
     */
    LIST_JIAMA_CHL(1045, "支付管理", "在线支付", "查看天豪加码充值渠道"),
    /**
     * 开关天豪充值渠道
     */
    SWITCH_DEPOSIT_CHL(1046, "支付管理", "在线支付", "开关天豪充值渠道"),
    /**
     * 编辑天豪充值渠道
     */
    EDIT_DEPOSIT_CHL(1047, "支付管理", "在线支付", "编辑天豪充值渠道"),
    /**
     * 设置天豪充值渠道 SDK 状态
     */
    SET_CHL_SDK_STATUS(1048, "支付管理", "在线支付", "设置天豪充值渠道 SDK 状态"),
    /**
     * 增加天豪线上充值渠道
     */
    ADD_ONLINE_CHL(1049, "支付管理", "在线支付", "增加天豪线上充值渠道"),
    /**
     * 增加天豪线下充值渠道
     */
    ADD_OFFLINE_CHL(1050, "支付管理", "在线支付", "增加天豪线下充值渠道"),
    /**
     * 增加天豪人工充值渠道
     */
    ADD_MANUAL_CHL(1051, "支付管理", "在线支付", "增加天豪人工充值渠道"),
    /**
     * 查询天豪汇款账号
     */
    LIST_REMIT_ACC(1052, "支付管理", "在线支付", "查询天豪汇款账号"),
    /**
     * 代理自己发起充值的记录
     */
    LIST_AGENT_RECHARGE_HIST(1053, "支付管理", "在线支付", "代理自己发起充值的记录"),
    /**
     * 查看可下发余额
     */
    LIST_AVAIL_PAY_BALANCE(1054, "", "", "查看可下发余额"),
    /**
     * 查看天豪线上充值订单列表
     */
    LIST_DEPOSIT_ONLINE(1055, "支付管理", "在线支付", "查看天豪线上充值订单列表"),
    /**
     * 查看天豪线下充值订单列表
     */
    LIST_DEPOSIT_OFFLINE(1056, "支付管理", "人工存款", "查看天豪线下充值订单列表"),
    /**
     * 查看天豪所有充值订单列表
     */
    LIST_DEPOSIT_ALL(1057, "财务管理", "玩家充值", "查看天豪所有充值订单列表"),
    /**
     * 查看已完成的提现列表
     */
    LIST_FINISHED_WITHDRAW(1058, "财务管理", "玩家提现", "查看已完成的提现列表"),
    /**
     * 查看未完成的提现列表
     */
    LIST_UNFINISHED_WITHDRAW(1059, "财务管理", "玩家提现", "查看未完成的提现列表"),
    /**
     * 查看所有的提现列表
     */
    LIST_ALL_WITHDRAW(1060, "财务管理", "玩家提现", "查看所有的提现列表"),
    /**
     * 查询自动下发付款记录
     */
    LIST_PAID_HIST(1061, "", "", "查询自动下发付款记录"),
    /**
     * 查询支付宝下发付款记录
     */
    LIST_ALI_PAID_HIST(1062, "", "", "查询支付宝下发付款记录"),
    /**
     * 查询玩家余额
     */
    GET_PLAYER_BALANCE(1063, "", "", "查询玩家余额"),
    /**
     * 补偿玩家余额
     */
    COMPENSATE_PLAYER(1064, "", "", "补偿玩家余额"),
    /**
     * 调整玩家保险箱余额
     */
    ADJ_PLAYER_BANK(1065, "", "", "调整玩家保险箱余额"),
    /**
     * 调整玩家背包
     */
    ADJ_PLAYER_BAG(1066, "", "", "调整玩家背包"),
    /**
     * 查询玩家余额调整的操作记录
     */
    LIST_BALANCE_OPER(1067, "财务管理", "余额调整记录", "查询玩家余额调整的操作记录"),
    /**
     * 天豪码库列表
     */
    LIST_MK(1068, "", "", "天豪码库列表"),
    /**
     * 天豪码库详情
     */
    DETAIL_MK(1069, "", "", "天豪码库详情"),
    /**
     * 新增码库
     */
    ADD_MK(1070, "", "", "新增码库"),
    /**
     * 编辑码库
     */
    EDIT_MK(1071, "", "", "编辑码库"),
    /**
     * 删除码库
     */
    DELETE_MK(1072, "", "", "删除码库"),
    /**
     * 切换码库启用状态
     */
    SWITCH_MK_STATUS(1073, "", "", "切换码库启用状态"),
    /**
     * 天豪支付大类列表
     */
    LIST_ALL_PAY_CHL(1074, "", "", "天豪支付大类列表"),
    /**
     * 设置天豪支付大类排序
     */
    SET_ALL_PAY_CHL(1075, "", "", "设置天豪支付大类排序"),
    /**
     * 玩家列表
     */
    LIST_PLAYER(1076, "玩家管理", "玩家列表", "玩家列表"),
    /**
     * 玩家识别快查列表
     */
    LIST_PLAYER_LITE(1077, "玩家管理", "玩家列表", "玩家识别快查列表"),
    /**
     * 玩家详情
     */
    DETAIL_PLAYER(1078, "玩家管理", "玩家列表", "玩家详情"),
    /**
     * 列出玩家所在的代理樹
     */
    PLAYER_TREE(1079, "玩家管理", "玩家列表", "列出玩家所在的代理树"),
    /**
     * 线上玩家列表
     */
    LIST_PLAYER_ONLINE(1080, "玩家管理", "玩家列表", "线上玩家列表"),
    /**
     * 第三方线上玩家列表
     */
    LIST_PLAYER_ONLINE_THIRD(1081, "玩家管理", "玩家列表", "第三方线上玩家列表"),
    /**
     * 玩家在游戏端的操作记录
     */
    LIST_PLAYER_TRACE(1082, "玩家管理", "玩家列表", "玩家在游戏端的操作记录"),
    /**  在线玩家 */
//	LIST_GAME_ONLINE_PLAYER_CNT(1083, "", "", ""),
    /**  第三方在线玩家 */
//	LIST_GAME_ONLINE_PLAYER_CNT_THIRD(1084, "", "", ""),
    /**
     * 封禁玩家
     */
    BLOCK_PLAYER(1085, "玩家管理", "玩家封号", "封禁玩家"),
    /**
     * 解封玩家
     */
    UNBLOCK_PLAYER(1086, "玩家管理", "玩家封号", "解封玩家"),
    /**
     * 群体封禁玩家 ID
     */
    BLOCK_PLAYER_GROUP(1087, "玩家管理", "玩家封号", "群体封禁玩家 ID"),
    /**
     * 封禁玩家 IP
     */
    BLOCK_PLAYER_IP(1088, "玩家管理", "玩家封号", "封禁玩家 IP"),
    /**
     * 查询指定代理以下可用游戏
     */
    GET_GAMES_BY_AGENT(1089, "", "", "查询指定代理以下可用游戏"),
    /**
     * 开关指定代理以下可用游戏
     */
    SWITCH_GAMES_BY_AGENT(1090, "", "", "开关指定代理以下可用游戏"),
    /**
     * 玩家支付绑定列表
     */
    LIST_PLAYER_BINDING(1091, "玩家管理", "玩家列表", "玩家支付绑定列表"),
    /**
     * 玩家支付绑定明细
     */
    DETAIL_PLAYER_BINDING(1092, "玩家管理", "玩家列表", "玩家支付绑定明细"),
    /**
     * 新增玩家支付绑定 - 银行卡
     */
    ADD_BANK_BINDING(1093, "玩家管理", "玩家列表", "新增玩家支付绑定 - 银行卡"),
    /**
     * 新增玩家支付绑定 - 支付宝
     */
    ADD_ALI_BINDING(1094, "玩家管理", "玩家列表", "新增玩家支付绑定 - 支付宝"),
    /**
     * 编辑玩家支付绑定 - 银行卡
     */
    EDIT_BANK_BINDING(1095, "玩家管理", "玩家列表", "编辑玩家支付绑定 - 银行卡"),
    /**
     * 编辑玩家支付绑定 - 支付宝
     */
    EDIT_ALI_BINDING(1096, "玩家管理", "玩家列表", "编辑玩家支付绑定 - 支付宝"),
    /**
     * 切换玩家支付绑定状态
     */
    SWITCH_PLAYER_BINDING(1097, "玩家管理", "玩家列表", "切换玩家支付绑定状态"),
    /**
     * 删除玩家支付绑定
     */
    DELETE_PLAYER_BINDING(1098, "玩家管理", "玩家列表", "删除玩家支付绑定"),
    /**
     * 自定义玩家组别列表
     */
    GET_PLAYER_GROUP_NAMES(1099, "玩家管理", "玩家列表", "自定义玩家组别列表"),
    /**
     * 获得异户清单
     */
    GET_IRR_PLAYERS(1100, "玩家管理", "玩家列表", "获得异户清单"),
    /**
     * 添加 id/ip/设备至异户名单
     */
    ADD_IRR(1101, "玩家管理", "玩家列表", "添加 id/ip/设备至异户名单"),
    /**
     * 查询组别内用户
     */
    LIST_PLAYERS_OF_GROUP(1102, "玩家管理", "玩家列表", "查询组别内用户"),
    /**
     * 从异户名单删除 多个id/ip/设备
     */
    DELETE_IRR(1103, "玩家管理", "玩家列表", "从异户名单删除 多个id/ip/设备"),
    /**
     * 创建活动
     */
    CREATE_PROMOTION(1104, "", "", "创建活动"),
    /**
     * 更新活动
     */
    UPDATE_PROMOTION(1105, "", "", "更新活动"),
    /**
     * 删除活动(草稿或过期活动, "", "", ""),
     */
    DELETE_PROMOTION(1106, "", "", "删除活动"),
    /**
     * 提交活动
     */
    SUBMIT_PROMOTION(1107, "", "", "提交活动"),
    /**
     * 促銷列表
     */
    LIST_PROMOTION(1108, "", "", "促销列表"),
    /**
     * 申请奖励大于0的活动列表
     */
    LIST_PROMOTION_WITH_UNHANDLED(1109, "", "", "申请奖励大于0的活动列表"),
    /**
     * 促銷詳情
     */
    DETAIL_PROMOTION(1110, "", "", "促销詳情"),
    /**
     * 审核活动
     */
    REVIEW_PROMOTION(1111, "", "", "审核活动"),
    /**
     * 立刻开始活动
     */
    START_PROMOTION(1112, "", "", "立刻开始活动"),
    /**
     * 立刻结束活动
     */
    END_PROMOTION(1113, "", "", "立刻结束活动"),
    /**
     * 取消活动
     */
    CANCEL_PROMOTION(1114, "", "", "取消活动"),
    /**
     * 活动奖励申请列表
     */
    LIST_PROMOTION_APPLY(1115, "", "", "活动奖励申请列表"),
    /**
     * 活动奖励申请详情
     */
    DETAIL_PROMOTION_APPLY(1116, "", "", "活动奖励申请详情"),
    /**
     * 处理活动奖励申请
     */
    HANDLE_PROMOTION_APPLY(1117, "", "", "处理活动奖励申请"),
    /**
     * 指定活动显示排序
     */
    SET_PROMOTION_ORDER(1118, "", "", "指定活动显示排序"),
    /**
     * 天豪活动大类列表
     */
    LIST_TH_PROMO_CATEGORY(1119, "活动管理", "活动分类", "天豪活动大类列表"),
    /**
     * 天豪活动大类明细
     */
    DETAIL_TH_PROMO_CATEGORY(1120, "活动管理", "活动分类", "天豪活动大类明细"),
    /**
     * 增加天豪活动大类
     */
    ADD_TH_PROMO_CATEGORY(1121, "活动管理", "活动分类", "增加天豪活动大类"),
    /**
     * 编辑天豪活动大类
     */
    EDIT_TH_PROMO_CATEGORY(1122, "活动管理", "活动分类", "编辑天豪活动大类"),
    /**
     * 切换天豪活动大类状态
     */
    SWITCH_TH_PROMO_CATEGORY(1123, "活动管理", "活动分类", "切换天豪活动大类状态"),
    /**
     * 删除天豪活动大类
     */
    DELETE_TH_PROMO_CATEGORY(1124, "活动管理", "活动分类", "删除天豪活动大类"),
    /**
     * 天豪活动子类列表
     */
    LIST_TH_PROMO_SUB(1125, "活动管理", "活动分类", "天豪活动子类列表"),
    /**
     * 天豪活动子类明细
     */
    DETAIL_TH_PROMO_SUB(1126, "活动管理", "活动分类", "天豪活动子类明细"),
    /**
     * 增加天豪活动子类
     */
    ADD_TH_PROMO_SUB(1127, "活动管理", "活动分类", "增加天豪活动子类"),
    /**
     * 编辑天豪活动子类
     */
    EDIT_TH_PROMO_SUB(1128, "活动管理", "活动分类", "编辑天豪活动子类"),
    /**
     * 切换天豪活动子类状态
     */
    SWITCH_TH_PROMO_SUB(1129, "活动管理", "活动分类", "切换天豪活动子类状态"),
    /**
     * 删除天豪活动子类
     */
    DELETE_TH_PROMO_SUB(1130, "活动管理", "活动分类", "删除天豪活动子类"),
    /**
     * 活动列表
     */
    LIST_TH_PROMO(1131, "活动管理", "活动设置", "活动列表"),
    /**
     * 切换活动状态
     */
    SWITCH_TH_PROMO(1132, "活动管理", "活动设置", "切换活动状态"),
    // 1000 end
    /**
     * 新增子账号
     */
    CREATE_ACCOUNT(4, "", "", "新增子账号"),
    /**
     * 更新子账号
     */
    UPDATE_ACCOUNT(5, "", "", "更新子账号"),
    /**
     * 移除子账号
     */
    DELETE_ACCOUNT(6, "", "", "移除子账号"),
    /**
     * 重設子账号密碼
     */
    RESET_PASSWORD(7, "", "", "重設子账号密码"),
    /**
     * 配置网站设定
     */
    UPDATE_APPEARANCE(18, "", "", "配置网站设定"),
    /**
     * 新增角色
     */
    CREATE_SCOPE(32, "", "", "新增角色"),
    /**
     * 更新角色
     */
    UPDATE_SCOPE(33, "", "", "更新角色"),
    /**
     * 刪除角色
     */
    DELETE_SCOPE(34, "", "", "刪除角色"),
    UPDATE_PAYMENT_DEPOSIT_SETTING(38, "", "", "刪除角色"),
    /**
     * 设定玩家是否可以提现
     */
    UPDATE_PLAYER_WITHDRAW_PERMISSION(41, "玩家管理", "玩家列表", "设定玩家是否可以提现"),
    /**
     * 对玩家加上标签
     */
    ADD_PLAYER_TAG(50, "玩家管理", "玩家列表", "对玩家加上标签"),
    /**
     * 对玩家移除标签
     */
    DELETE_PLAYER_TAG(51, "玩家管理", "玩家列表", "对玩家移除标签"),
    /**
     * 增加标签
     */
    ADD_TAG(52, "用户标签", "标签管理", "增加标签"),
    /**
     * 更新标签
     */
    UPDATE_TAG(53, "用户标签", "标签管理", "更新标签"),
    /**
     * 删除标签
     */
    DELETE_TAG(54, "用户标签", "标签管理", "删除标签"),

    /**
     * 删除陪玩
     */
    DELETE_PLAY_WITH_USER(55, "分控管理", "陪玩设置", "删除陪玩"),
    CREATE_PLAY_WITH_USER(56, "分控管理", "陪玩设置", "创建陪玩"),
    UPDATE_PAYMENT_WITHDRAW_SETTING(61, "", "", ""),
    CREATE_BANK_ACCOUNT(63, "", "", ""),
    UPDATE_BANK_ACCOUNT(64, "", "", ""),
    DELETE_BANK_ACCOUNT(65, "", "", ""),
    /**
     * 配置应用设置
     */
    UPDATE_APP_SETTING(67, "网站管理", "应用设置", "配置应用设置"),
    /**
     * 切换维护状态
     */
    MAINTAIN_COMPANY(72, "", "", "切换维护状态"),
    /**
     * 套用标签
     */
    APPLY_TAG(83, "用户标签", "标签管理", "套用标签"),
    REVIEW_WITHDRAW(87, "", "", ""),
    AUDIT_WITHDRAW(88, "支付管理", "提现管理", "审核天豪提现订单"),
    AUDIT_DEPOSIT(89, "", "", ""),
    /**
     * 重置玩家密码
     */
    RESET_PLAYER_PASSWORD(90, "玩家管理", "玩家列表", "重置玩家密码"),
    /**
     * 切换运营商状态
     */
    SWITCH_COMPANY_STATUS(91, "", "", "切换运营商状态"),
    /**
     * 设定白名单 IP
     */
    SET_IP_WHITELIST(92, "", "", "设定白名单 IP"),
    /**
     * 移除白名单 IP
     */
    DELETE_WHITELIST_IP(93, "", "", "移除白名单 IP"),
    /**
     * 设定允许的玩家所在国家
     */
    SET_PLAYER_COUNTRY(94, "", "", "设定允许的玩家所在国家"),
    /**
     * 设定允许登入 BO 的运营商 ip，admin 专用
     */
    SET_OWNER_IPS(95, "", "", "设定允许登入 BO 的运营商 ip，admin 专用"),
    /**
     * 增加域名
     */
    ADD_DOMAIN(96, "网站管理", "域名管理", "增加域名"),
    /**
     * 编辑域名
     */
    EDIT_DOMAIN(97, "网站管理", "域名管理", "编辑域名"),
    /**
     * 删除域名
     */
    DELETE_DOMAIN(98, "网站管理", "域名管理", "删除域名"),
    /**
     * 配置玩家等级设置
     */
    UPDATE_PLAYER_LEVEL_SETTING(99, "玩家管理", "等级设置", "配置玩家等级设置"),
    /**
     * 配置玩家洗码设置
     */
    UPDATE_PLAYER_REBATE_SETTING(100, "玩家管理", "等级设置", "配置玩家洗码设置"),
    SET_UP_AGENT_AUTH(101, "", "", ""),
    /**
     * 切换代理可登入状态
     */
    DISABLE_AGENT_AUTH(102, "代理管理", "代理列表", "切换代理可登入状态"),
    /**
     * 重置代理登入密码
     */
    RESET_AGENT_PW(103, "代理管理", "代理列表", "重置代理登入密码"),
    /**
     * 审核天豪充值订单
     */
    AUDIT_DEPOSIT_TH(104, "支付管理", "填单存款", "审核天豪充值订单"),
    /**
     * 重置运营商 BO 登入密码
     */
    RESET_COMPAMY_PW(105, "", "", "重置运营商 BO 登入密码"),
    /**
     * 审核天豪提现订单
     */
    AUDIT_WITHDRAW_TH(106, "支付管理", "提现管理", "审核天豪提现订单"),
    /**
     * 天豪人工存款
     */
    MANUAL_SAVE(107, "支付管理", "人工充值", "天豪人工存款"),
    /**
     * 天豪人工扣款
     */
    MANUAL_DEDUCT(108, "支付管理", "人工扣款", "天豪人工扣款"),
    /**
     * 调用天豪代付
     */
    REQUEST_DAIFU_TH(109, "支付管理", "", "调用天豪代付"),
    /**
     * 调用天豪保存汇款
     */
    MARK_REMIT(110, "支付管理", "", "调用天豪保存汇款"),
    ADD_AD_AGENT(111, "", "", ""),
    REMOVE_AD_AGENT(112, "", "", ""),
    /**
     * 新增跑马灯
     */
    CREATE_HORN(113, "网站管理", "跑马灯", "新增跑马灯"),
    /**
     * 编辑跑马灯
     */
    EDIT_HORN(114, "网站管理", "跑马灯", "编辑跑马灯"),
    /**
     * 切换跑马灯状态
     */
    SWITCH_HORN(115, "网站管理", "跑马灯", "切换跑马灯状态"),
    /**
     * 删除跑马灯
     */
    DELETE_HORN(116, "网站管理", "跑马灯", "删除跑马灯"),
    /**
     * 修改密码
     */
    CHANGE_PASSWORD(117, "", "", "修改密码"),
    /**
     * 发天豪邮件给指定下线
     */
    SEND_MAIL(118, "客户服务", "邮件管理", "发天豪邮件给指定下线"),
    /**
     * 代理层级保底设置
     */
    SET_AGENT_PERFORM_LV(119, "玩家管理", "玩家列表", "代理层级保底设置"),
    /**
     * 建立可登入的代理
     */
    ADD_AGENT_AUTH(120, "代理管理", "代理列表", "建立可登入的代理"),
    /**
     * 编辑可登入的代理
     */
    EDIT_AGENT_AUTH(121, "代理管理", "代理列表", "编辑可登入的代理"),
    /**
     * 代理发起充值删除可登入代理
     */
    AGENT_RECHARGE(122, "", "", "代理发起充值删除可登入代理"),
    /**
     * 删除可登入代理
     */
    DELETE_AGENT_AUTH(123, "代理管理", "代理列表", "删除可登入代理"),
    /**
     * 新增弹窗公告
     */
    CREATE_NOTIC(124, "客户服务", "弹窗公告", "新增弹窗公告"),
    /**
     * 编辑弹窗公告
     */
    EDIT_NOTIC(125, "客户服务", "弹窗公告", "编辑弹窗公告"),
    /**
     * 切换弹窗公告状态
     */
    SWITCH_NOTIC(126, "客户服务", "弹窗公告", "切换弹窗公告状态"),
    /**
     * 删除弹窗公告
     */
    DELETE_NOTIC(127, "客户服务", "弹窗公告", "删除弹窗公告"),
    /**
     * 配置主站代理业绩设定
     */
    SET_MAIN_COMMISSIONS(128, "财务管理", "工资设置", "配置主站代理业绩设定"),
    /**
     * 配置第三方代理业绩设定
     */
    SET_THIRD_COMMISSIONS(129, "财务管理", "工资设置", "配置第三方代理业绩设定"),
    /**
     * 增加推广代理组别
     */
    ADD_AD_AGENT_GROUP(130, "报表", "推广报表", "增加推广代理组别"),
    /**
     * 配置推广代理
     */
    SET_AD_AGENTS(131, "报表", "推广报表", "配置推广代理"),
    /**
     * 编辑推广代理组别
     */
    EDIT_AD_AGENT_GROUP(132, "报表", "推广报表", "编辑推广代理组别"),
    /**
     * 删除推广代理组别
     */
    DELETE_AD_AGENT_GROUP(133, "报表", "推广报表", "删除推广代理组别"),
    /**
     * 绑定玩家手机号
     */
    ADD_PHONE_BINDING(134, "玩家管理", "玩家列表", "绑定玩家手机号"),
    /**
     * 解绑玩家手机号
     */
    DEL_PHONE_BINDING(135, "玩家管理", "玩家列表", "解绑玩家手机号"),
    /**
     * 记录搜索历史代理 ID
     */
    ADD_AD_AGENTS_HISTORY(136, "报表", "推广报表", "记录搜索历史代理 ID"),
    /**
     * 发天豪邮件给指定下线
     */
    SEND_SMS(137, "客户服务", "短信管理", "发天豪邮件给指定下线"),
    /**
     * 增加自定义玩家组别
     */
    ADD_PLAYER_GROUP(138, "报表", "玩家账目报表", "增加自定义玩家组别"),
    /**
     * 配置组别内用户
     */
    SET_GROUP_PLAYERS(139, "报表", "玩家账目报表", "配置组别内用户"),
    /**
     * 记录搜索历史用户 ID
     */
    ADD_GROUP_PLAYER_HISTORY(140, "报表", "玩家账目报表", "记录搜索历史用户 ID"),

    /**
     * 重置玩家基本資料
     */
    RESET_BASE_INFO(141, "玩家管理", "玩家列表", "重置玩家基本資料"),

    /**
     * 编辑自定义玩家组别
     */
    EDIT_PLAYER_GROUP(1200, "报表", "玩家账目报表", "编辑自定义玩家组别"),
    /**
     * 删除自定义玩家组别
     */
    DELETE_PLAYER_GROUP(1201, "报表", "玩家账目报表", "删除自定义玩家组别"),

    // 2000 up
    /**
     * 子账号詳情
     */
    GET_ACCOUNT(2000, "", "", "子账号詳情"),
    /**
     * 子账号列表
     */
    GET_ACCOUNTS(2001, "", "", "子账号列表"),
    /**
     * 查询代理列表
     */
    LIST_AGENTS(2002, "代理管理", "代理列表", "查询代理列表"),
    /**
     * 查询代理细节
     */
    GET_AGENT(2003, "代理管理", "代理列表", "查询代理细节"),
    /**
     * 取得代理推广连结
     */
    GET_AGENT_SPREAD_URL(2004, "代理管理", "", "取得代理推广连结"),
    /**
     * 代理层级保底查询
     */
    GET_PERFORM_LEVEL(2005, "代理管理", "", "代理层级保底查询"),
    /**
     * 推广代理组别列表
     */
    GET_AD_AGENT_GROUP_NAMES(2006, "报表", "推广报表", "推广代理组别列表"),
    /**
     * 查询推广代理
     */
    GET_AD_AGENT_GROUP_AGENTS(2007, "报表", "推广报表", "查询推广代理"),
    /**
     * 查询主站代理业绩设定
     */
    GET_MAIN_COMS_SETTINGS(2008, "玩家管理", "玩家列表", "查询主站代理业绩设定"),
    /**
     * 查询第三方代理业绩设定
     */
    GET_THIRD_COMS_SETTINGS(2009, "玩家管理", "玩家列表", "查询第三方代理业绩设定"),
    /**
     * 获得代理UI设置
     */
    GET_UI_CONFIG(2010, "", "", "获得代理UI设置"),
    /**
     * 修改代理UI设置
     */
    SET_UI_CONFIG(2011, "", "", "修改代理UI设置"),
    /**
     * 网站公告列表
     */
    GET_ANNOUNCE_LIST(2012, "客户服务", "网站公告", "网站公告列表"),
    /**
     * 网站公告内文
     */
    GET_ANNOUNCE(2013, "客户服务", "网站公告", "网站公告内文"),
    /**
     * 指定公告显示排序
     */
    SET_ANNOUNCE_LIST_ORDER(2014, "客户服务", "网站公告", "指定公告显示排序"),
    /**
     * 公告列表
     */
    GET_TH_ANNOUNCE_LIST(2015, "客户服务", "网站公告", "公告列表"),
    /**
     * 切换公告状态
     */
    SWITCH_TH_ANNOUNCE(2016, "客户服务", "网站公告", "切换公告状态"),
    /**
     * 异常讯息列表
     */
    GET_ANOMALY_LIST(2017, "首页", "", "异常讯息列表"),
    /**
     * 查询玩家数量
     */
    GET_PLAYER_COUNT(2018, "报表", "玩家报表", "查询玩家数量"),
    /**
     * 查询线上玩家报表
     */
    GET_PLAYER_ONLINE_REPORT(2019, "报表", "", "查询线上玩家报表"),
    /**
     * 查询游戏报表
     */
    GET_GAME_REPORT(2020, "报表", "游戏报表", "查询游戏报表"),
    /**
     * 查询对账报表
     */
    GET_ACCOUNT_REPORT(2021, "报表", "对账报表", "查询对账报表"),
    /**
     * 查询银行账户报表
     */
    GET_BANK_FINANCE_REPORT(2022, "报表", "财务报表", "查询银行账户报表"),
    /**
     * 查询背包账户报表
     */
    GET_BAG_FINANCE_REPORT(2023, "报表", "财务报表", "查询背包账户报表"),
    /**
     * 查询充值区间次数报表
     */
    GET_DEPOSIT_GAP_REPORT(2024, "报表", "充值报表", "查询充值区间次数报表"),
    /**
     * 查询充值金额趋势报表
     */
    GET_DEPOSIT_TREND_REPORT(2025, "报表", "充值报表", "查询充值金额趋势报表"),
    /**
     * 查询提现区间次数报表
     */
    GET_WITHDRAW_GAP_REPORT(2026, "报表", "提现报表", "查询提现区间次数报表"),
    /**
     * 查询提现金额趋势报表
     */
    GET_WITHDRAW_TREND_REPORT(2027, "报表", "提现报表", "查询提现金额趋势报表"),
    /**
     * 查询日提现金额报表
     */
    GET_WITHDRAW_DAILY_REPORT(2028, "报表", "提现报表", "查询日提现金额报表"),
    /**
     * 查询主游戏报表
     */
    GET_OPERATION_MAIN_GAME_REPORT(2029, "报表", "运营报表", "查询主游戏报表"),
    /**
     * 查询第三方游戏报表
     */
    GET_OPERATION_THIRD_GAME_REPORT(2030, "报表", "运营报表", "查询第三方游戏报表"),
    /**
     * 查询游戏收益报表
     */
    GET_OPERATION_PROFIT_REPORT(2031, "报表", "运营报表", "查询游戏收益报表"),
    /**
     * 查询所有游戏报表
     */
    GET_OPERATION_ALL_REPORT(2032, "报表", "运营报表", "查询所有游戏报表"),
    /**
     * 查询综合运营报表
     */
    GET_OPERATION_COMPOSITE_REPORT(2033, "报表", "综合报表", "查询综合运营报表"),
    /**
     * 查询推广报表
     */
    GET_AD_REPORT(2034, "报表", "推广报表", "查询推广报表"),
    /**
     * 查询玩家财务统计报表
     */
    GET_FINANCE_PLAYER_REPORT(2035, "报表", "财务报表", "查询玩家财务统计报表"),
    /**
     * 查询重复玩家报表
     */
    GET_DUPLICATE_PLAYER(2036, "报表", "", "查询重复玩家报表"),
    /**
     * 角色詳情
     */
    GET_SCOPE(2037, "账号管理", "角色", "角色詳情"),
    /**
     * 角色列表
     */
    GET_SCOPES(2038, "账号管理", "角色", "角色列表"),
    /**
     * 查询网站设定
     */
    GET_WEBSITE_SETTING(2039, "", "", "查询网站设定"),
    /**
     * 查询应用设置
     */
    GET_APP_SETTING(2040, "网站管理", "应用设置", "查询应用设置"),
    /**
     * 查询短讯发送记录
     */
    GET_TH_SMS_HISTORY(2041, "", "", "查询短讯发送记录"),
    /**
     * 查询标签列表
     */
    GET_TAG_LIST(2042, "用户标签", "标签管理", "查询标签列表"),
    /**
     * 查询标签详情
     */
    GET_TAG(2043, "用户标签", "标签管理", "查询标签详情"),
    /**
     * 按标签查询玩家列表
     */
    GET_PLAYERS_BY_TAG(2044, "用户标签", "已标签用户", "按标签查询玩家列表"),
    /**
     * 预览标签
     */
    PREVIEW_TAG(2045, "用户标签", "标签管理", "预览标签"),
    /**
     * 查询讯息列表
     */
    GET_MESSAGE_LIST(2046, "", "", "查询讯息列表"),
    /**
     * 查询讯息线
     */
    GET_MESSAGE_THREAD(2047, "", "", "查询讯息线"),
    /**
     * 新增讯息
     */
    ADD_MESSAGE(2048, "", "", "新增讯息"),
    /**
     * 回复讯息
     */
    REPLY_MESSAGE(2049, "", "", "回复讯息"),
    /**
     * 结束讯息线
     */
    CLOSE_TICKET(2050, "", "", "结束讯息线"),
    /**
     * 日誌列表
     */
    GET_TRACE_LIST(2051, "", "", "日志列表"),
    /**
     * IP 白名单
     */
    GET_WHITE_LIST(2052, "", "", "IP 白名单"),

    /**
     * 综合运营报表到处
     */
    COMPOSITE_REPORT_EXPORT(2053, "报表", "综合报表", "导出综合运营报表"),

    /**
     * 查看天豪快捷充值订单列表
     */
    LIST_DEPOSIT_QUICK(2100, "", "", "查看天豪快捷充值订单列表"),
    /**
     * 所有游戏列表
     */
    LIST_ALL_GAMES(2101, "", "", "所有游戏列表"),
    /**
     * 查询充值区间次数报表
     */
    GET_DEPOSIT_DAILY_PLAYERGAP_REPORT(2102, "报表", "充值报表", "查询充值区间次数报表"),

    GET_LANDPAGE_LIST(2103, "报表", "落地页统计", "落地页统计列表"),
    GET_LANDPAGE_GROUP(2104, "报表", "落地页统计", "落地页统计汇总"),
    ROOM_MONITOR(2105, "", "", ""),
    GOOGLE_CHANGE_SECRET(2161, "系统设置", "账号管理", "更新账户安全秘钥"),
    GOOGLE_CHANGE_GCODEAUTH(2162, "系统设置", "账号管理", "是否开启谷歌校验"),
    GOOGLE_GCODEAUTH(2163, "系统设置", "账号管理", "谷歌二次校验"),

    /*活动管理*/
    ACTIVITY_MANAGE_LIST(2106, "活动管理", "活动管理", "活动信息列表"),
    ACTIVITY_MANAGE_DETAIL(2107, "活动管理", "活动管理", "活动信息详情"),
    ACTIVITY_MANAGE_ADD(2108, "活动管理", "活动管理", "新增活动信息"),
    ACTIVITY_MANAGE_EDIT(2109, "活动管理", "活动管理", "修改活动信息"),
    ACTIVITY_MANAGE_DEL(2110, "活动管理", "活动管理", "删除活动信息"),
    ACTIVITY_MANAGE_STATUS(2111, "活动管理", "活动管理", "修改活动信息状态"),
    ACTIVITY_MANAGE_IMAGE(2112, "活动管理", "活动管理", "活动信息图片上传"),
    ACTIVITY_MANAGE_GAMETREES(2113, "活动管理", "活动管理", "活动信息游戏树"),
    ACTIVITY_RECORD_LIST(2114, "活动管理", "活动管理", "活动记录列表"),

    /*任务管理*/
    TASK_MANAGE_LIST(2115, "活动管理", "任务管理", "任务信息列表"),
    TASK_MANAGE_DETAIL(2116, "活动管理", "任务管理", "任务信息详情"),
    TASK_MANAGE_ADD(2117, "活动管理", "任务管理", "新增任务信息"),
    TASK_MANAGE_EDIT(2118, "活动管理", "任务管理", "修改任务信息"),
    TASK_MANAGE_DEL(2119, "活动管理", "任务管理", "删除任务信息"),
    TASK_MANAGE_STATUS(2120, "活动管理", "任务管理", "修改任务信息状态"),
    TASK_RECORD_LIST(2121, "活动管理", "任务管理", "任务记录列表"),

    /*活动分类（新）*/
    ACTIVITY_CATEGORY_FIRST(2122, "活动管理", "活动分类", "一级活动分类"),
    ACTIVITY_CATEGORY_SECOND(2123, "活动管理", "活动分类", "二级活动分类"),
    ACTIVITY_CATEGORY_DETAIL(2124, "活动管理", "活动分类", "活动分类详情"),
    ACTIVITY_CATEGORY_ADD(2125, "活动管理", "活动分类", "新增活动分类"),
    ACTIVITY_CATEGORY_EDIT(2126, "活动管理", "活动分类", "修改活动分类"),
    ACTIVITY_CATEGORY_DEL(2127, "活动管理", "活动分类", "删除活动分类"),
    ACTIVITY_CATEGORY_STATUS(2128, "活动管理", "活动分类", "修改活动分类状态"),
    ACTIVITY_CATEGORY_SELECT(2129, "活动管理", "活动分类", "活动分类下拉列表"),
    ACTIVITY_CATEGORY_EXIST(2130, "活动管理", "活动分类", "活动分类是否存在"),

    UPDATE_IS_WELFARE(1333, "玩家管理", "玩家列表", "是否可以领取福利"),

    SAVE_MAIL_TEMPLATE(2164, "客户服务", "邮件管理", ""),
    UPDATE_MAIL_TEMPLATE(2165, "客户服务", "邮件管理", ""),
    DEL_MAIL_TEMPLATE(2166, "客户服务", "邮件管理", ""),
    GET_MAIL_TEMPLATE(2167, "客户服务", "邮件管理", ""),
    PLAY_WITH_USER_LIST(2168, "分控管理", "陪玩设置", "陪玩设置列表"),

    /*菜单栏管理*/
    SYSTEMSET_MENU_TREE(2169, "系统设置", "菜单栏管理", "菜单树"),
    SYSTEMSET_MENU_LIST(2170, "系统设置", "菜单栏管理", "菜单列表"),
    SYSTEMSET_MENU_DETAIL(2171, "系统设置", "菜单栏管理", "菜单详情"),
    SYSTEMSET_MENU_ADD(2172, "系统设置", "菜单栏管理", "新增菜单"),
    SYSTEMSET_MENU_EDIT(2173, "系统设置", "菜单栏管理", "修改菜单"),
    SYSTEMSET_MENU_DEL(2174, "系统设置", "菜单栏管理", "删除菜单"),
    SYSTEMSET_MENU_STATUS(2175, "系统设置", "菜单栏管理", "更改菜单状态"),

    /*角色管理*/
    SYSTEMSET_ROLE_TREE(2176, "系统设置", "角色管理", "角色树"),
    SYSTEMSET_ROLE_DETAIL(2177, "系统设置", "角色管理", "角色详情"),
    SYSTEMSET_ROLE_ADD(2178, "系统设置", "角色管理", "新增角色"),
    SYSTEMSET_ROLE_EDIT(2179, "系统设置", "角色管理", "修改角色"),
    SYSTEMSET_ROLE_DEL(2180, "系统设置", "角色管理", "删除角色"),

    /*账号管理*/
    SYSTEMSET_ACCOUNT_LIST(2181, "系统设置", "账号管理", "账号列表"),
    SYSTEMSET_ACCOUNT_DETAIL(2182, "系统设置", "账号管理", "账号详情"),
    SYSTEMSET_ACCOUNT_ADD(2183, "系统设置", "账号管理", "新增账号"),
    SYSTEMSET_ACCOUNT_EDIT(2184, "系统设置", "账号管理", "修改账号"),
    SYSTEMSET_ACCOUNT_DEL(2185, "系统设置", "账号管理", "删除账号"),
    SYSTEMSET_ACCOUNT_STATUS(2208, "系统设置", "账号管理", "状态变更"),

    /*数据字典*/
    SYSTEMSET_DICTGROUP_TREE(2186, "系统设置", "数据字典", "字典树"),
    SYSTEMSET_DICTGROUP_DETAIL(2187, "系统设置", "数据字典", "字典分组详情"),
    SYSTEMSET_DICTGROUP_ADD(2188, "系统设置", "数据字典", "新增字典分组"),
    SYSTEMSET_DICTGROUP_EDIT(2189, "系统设置", "数据字典", "修改字典分组"),
    SYSTEMSET_DICTGROUP_DEL(2190, "系统设置", "数据字典", "删除字典分组"),
    SYSTEMSET_DICT_LIST(2191, "系统设置", "数据字典", "数据字典列表"),
    SYSTEMSET_DICT_DETAIL(2192, "系统设置", "数据字典", "数据字典详情"),
    SYSTEMSET_DICT_ADD(2193, "系统设置", "数据字典", "新增数据字典"),
    SYSTEMSET_DICT_EDIT(2194, "系统设置", "数据字典", "修改数据字典"),
    SYSTEMSET_DICT_DEL(2195, "系统设置", "数据字典", "删除数据字典"),
    SYSTEMSET_DICT_STATUS(2196, "系统设置", "数据字典", "修改数据字典状态"),

    /*代理数据字典*/
    SYSTEMSET_DICTAGENT_LIST(2197, "系统设置", "代理数据字典", "代理数据字典列表"),
    SYSTEMSET_DICTAGENT_DETAIL(2198, "系统设置", "代理数据字典", "代理数据字典详情"),
    SYSTEMSET_DICTAGENT_ADD(2199, "系统设置", "代理数据字典", "新增代理数据字典"),
    SYSTEMSET_DICTAGENT_EDIT(2201, "系统设置", "代理数据字典", "修改代理数据字典"),
    SYSTEMSET_DICTAGENT_DEL(2202, "系统设置", "代理数据字典", "删除代理数据字典"),
    SYSTEMSET_DICTAGENT_STATUS(2203, "系统设置", "代理数据字典", "修改代理数据字典状态"),
    SYSTEMSET_DICTAGENT_TREE(2204, "系统设置", "代理数据字典", "代理数据字典树"),

    /*操作日志*/
    SYSTEMSET_OPRLOG_LIST(2205, "系统设置", "操作日志", "操作日志列表"),

    /*登录日志*/
    SYSTEMSET_LOGINLOG_LIST(2206, "系统设置", "登录日志", "登录日志列表"),

    WELFAREACTIONTYPE_LIST(2236, "系统设置", "福利管理", "福利类型列表"),
    WELFAREACTIONTYPE_SAVE(2237, "系统设置", "福利管理", "福利类型保存"),

    /*账户账号管理*/
    MERCHANT_ACCOUNT_LIST(2207, "商户管理", "商户账号管理", "商户账号列表"),
    MERCHANT_ACCOUNT_ADD(2209, "商户管理", "商户账号管理", "新增商户"),
    MERCHANT_ACCOUNT_STATUS(2210, "商户管理", "商户账号管理", "状态变更"),
    MERCHANT_ACCOUNT_BANKMONEY(2211, "商户管理", "商户账号管理", "余额充值"),
    MERCHANT_ACCOUNT_EDIT(2212, "商户管理", "商户账号管理", "编辑商户"),
    MERCHANT_ACCOUNT_PERMISSION(2213, "商户管理", "商户账号管理", "支付渠道"),
    MERCHANT_ACCOUNT_RECHARGE(2214, "商户管理", "商户账号管理", "代理支付渠道"),
    MERCHANT_ACCOUNT_GAMES(2215, "商户管理", "商户账号管理", "游戏配置"),
    MERCHANT_ACCOUNT_DOMAIN(2216, "商户管理", "商户账号管理", "域名管理"),
    MERCHANT_ACCOUNT_DOMAIN_ADD(2217, "商户管理", "商户账号管理", "新增域名"),
    MERCHANT_ACCOUNT_DOMAIN_EDIT(2218, "商户管理", "商户账号管理", "编辑域名"),
    MERCHANT_ACCOUNT_DOMAIN_DELETE(2219, "商户管理", "商户账号管理", "删除域名"),
    MERCHANT_ACCOUNT_DOMAIN_STATUS(2220, "商户管理", "商户账号管理", "修改域名状态"),

    /*商户邮件管理*/
    MERCHANT_MAIL_LIST(2222, "商户管理", "商户邮件管理", "商户邮件列表"),
    MERCHANT_MAIL_ADD(2223, "商户管理", "商户邮件管理", "商户邮件新增"),
    MERCHANT_MAIL_UPDATE_STATE(2224, "商户管理", "商户邮件管理", "商户邮件状态更新"),
    MERCHANT_MAIL_UPDATE(2225, "商户管理", "商户邮件管理", "商户邮件更新"),
    MERCHANT_MAIL_DELETE(2226, "商户管理", "商户邮件管理", "商户邮件删除"),

    /*工单管理*/
    WORKORDER_MANAGE_LIST(2227, "活动管理", "工单管理", "工单列表"),
    WORKORDER_MANAGE_ADD(2228, "活动管理", "工单管理", "新增工单"),
    WORKORDER_MANAGE_DEAL(2229, "活动管理", "工单管理", "处理工单"),
    WORKORDER_MANAGE_COUNT(2230, "活动管理", "工单管理", "工单数量"),

    /*基本数据分析*/
    DATA_ANALYSIST_FIRSTRECHARGE(2221, "运营数据分析", "基本数据分析", "首充分析"),
    DATA_ANALYSIST_RETENTION(2231, "运营数据分析", "基本数据分析", "留存分析"),
    DATA_ANALYSIST_CHANGE(2232, "运营数据分析", "基本数据分析", "转化率分析"),
    DATA_ANALYSIST_TERMINAL(2233, "运营数据分析", "基本数据分析", "终端分析"),
    DATA_ANALYSIST_GAME(2234, "运营数据分析", "基本数据分析", "游戏分析"),


    BLOCK_PLAYER_GROUP_ALL(2235, "玩家管理", "玩家封号", "群体查禁/解封玩家"),

    /*新活动管理*/
    NEW_ACTIVITY_LIST(2238, "活动管理", "新活动管理", "活动信息列表"),
    NEW_ACTIVITY_DETAIL(2239, "活动管理", "新活动管理", "活动信息详情"),
    NEW_ACTIVITY_ADD(2240, "活动管理", "新活动管理", "新增活动信息"),
    NEW_ACTIVITY_EDIT(2241, "活动管理", "新活动管理", "修改活动信息"),
    NEW_ACTIVITY_DEL(2242, "活动管理", "新活动管理", "删除活动信息"),
    NEW_ACTIVITY_STATUS(2243, "活动管理", "新活动管理", "修改活动信息状态"),
    NEW_ACTIVITY_IMAGE(2244, "活动管理", "新活动管理", "图片上传"),
    NEW_ACTIVITY_GAMETREES(2245, "活动管理", "新活动管理", "游戏树"),

    /*新任务管理*/
    NEW_TASK_LIST(2246, "活动管理", "新任务管理", "任务信息列表"),
    NEW_TASK_DETAIL(2247, "活动管理", "新任务管理", "任务信息详情"),
    NEW_TASK_ADD(2248, "活动管理", "新任务管理", "新增任务信息"),
    NEW_TASK_EDIT(2249, "活动管理", "新任务管理", "修改任务信息"),
    NEW_TASK_DEL(2250, "活动管理", "新任务管理", "删除任务信息"),
    NEW_TASK_STATUS(2251, "活动管理", "新任务管理", "修改任务信息状态"),

    /*新公告管理*/
    NEW_NOTICE_LIST(2252, "活动管理", "新公告管理", "公告信息列表"),
    NEW_NOTICE_ADD(2253, "活动管理", "新公告管理", "新增公告信息"),
    NEW_NOTICE_EDIT(2254, "活动管理", "新公告管理", "修改公告信息"),
    NEW_NOTICE_DEL(2255, "活动管理", "新公告管理", "删除公告信息"),

    /*银商管理*/
    BANK_MERCHANT_LIST(2256, "代理管理", "银商管理", "银商列表"),
    BANK_MERCHANT_ADD(2257, "代理管理", "银商管理", "新增银商信息"),
    BANK_MERCHANT_STATUS(2258, "代理管理", "银商管理", "修改银商状态"),
    BANK_MERCHANT_GCODE_RESET(2301, "代理管理", "银商管理", "重置谷歌秘钥"),
    BANK_MERCHANT_GCODE_STATUS(2302, "代理管理", "银商管理", "银商账号谷歌秘钥开关"),
    /*转账管理*/
    BANK_PLAYER_LIST(2259, "支付管理", "转账管理", "用户转账申请列表"),
    BANK_PLAYER_AUDIT(2260, "支付管理", "转账管理", "用户转账申请审核"),


    PROFIT_RANKING_LIST(2261, "分控管理", "累计盈利排行榜", "累计盈利排行榜列表"),
    PROFIT_RANKING_KILL(2262, "分控管理", "累计盈利排行榜", "累计盈利排行榜追杀/取消追杀"),

    BANKINFO_LIST(2264, "支付管理", "银行维护", "银行维护列表"),
    BANKINFO_SAVE(2265, "支付管理", "银行维护", "银行维护保存"),

    PAY_CHANNEL_DEL(2266, "人工存款", "渠道设置", "删除"),

    GAMES_CATEGORY_SUPER_LIST(2267, "游戏管理", "游戏分类-超管", "列表"),
    GAMES_CATEGORY_SUPER_ADD(2268, "游戏管理", "游戏分类-超管", "新增"),
    GAMES_CATEGORY_SUPER_EDIT(2269, "游戏管理", "游戏分类-超管", "修改"),
    GAMES_CATEGORY_SUPER_DEL(2270, "游戏管理", "游戏分类-超管", "删除"),
    GAMES_CATEGORY_SUPER_STATUS(2271, "游戏管理", "游戏分类-超管", "状态"),

    GAMES_CATEGORY_COMPANY_LIST(2272, "游戏管理", "游戏分类-总代", "列表"),
    GAMES_CATEGORY_COMPANY_ADD(2273, "游戏管理", "游戏分类-总代", "新增"),
    GAMES_CATEGORY_COMPANY_EDIT(2274, "游戏管理", "游戏分类-总代", "修改"),
    GAMES_CATEGORY_COMPANY_DEL(2275, "游戏管理", "游戏分类-总代", "删除"),
    GAMES_CATEGORY_COMPANY_STATUS(2276, "游戏管理", "游戏分类-总代", "状态"),

    GAMES_PLATINFO_SUPER_LIST(2277, "游戏管理", "游戏平台-超管", "列表"),
    GAMES_PLATINFO_SUPER_ADD(2278, "游戏管理", "游戏平台-超管", "新增"),
    GAMES_PLATINFO_SUPER_EDIT(2279, "游戏管理", "游戏平台-超管", "修改"),
    GAMES_PLATINFO_SUPER_DEL(2280, "游戏管理", "游戏平台-超管", "删除"),
    GAMES_PLATINFO_SUPER_STATUS(2281, "游戏管理", "游戏平台-超管", "状态"),

    GAMES_PLATINFO_COMPANY_LIST(2282, "游戏管理", "游戏平台-总代", "列表"),
    GAMES_PLATINFO_COMPANY_ADD(2283, "游戏管理", "游戏平台-总代", "新增"),
    GAMES_PLATINFO_COMPANY_EDIT(2284, "游戏管理", "游戏平台-总代", "修改"),
    GAMES_PLATINFO_COMPANY_DEL(2285, "游戏管理", "游戏平台-总代", "删除"),
    GAMES_PLATINFO_COMPANY_STATUS(2286, "游戏管理", "游戏平台-总代", "状态"),

    GAMES_CONFIG_SUPER_LIST(2287, "游戏管理", "游戏配置-超管", "列表"),
    GAMES_CONFIG_SUPER_ADD(2288, "游戏管理", "游戏配置-超管", "新增"),
    GAMES_CONFIG_SUPER_EDIT(2289, "游戏管理", "游戏配置-超管", "修改"),
    GAMES_CONFIG_SUPER_DEL(2290, "游戏管理", "游戏配置-超管", "删除"),
    GAMES_CONFIG_SUPER_STATUS(2291, "游戏管理", "游戏配置-超管", "状态"),
    GAMES_CONFIG_SUPER_SCREEN(2292, "游戏管理", "游戏配置-超管", "屏幕方式"),
    GAMES_CONFIG_SUPER_SORTS(2293, "游戏管理", "游戏配置-超管", "排序"),
    GAMES_CONFIG_SUPER_IMPORT(2294, "游戏管理", "游戏配置-超管", "导入"),
    GAMES_CONFIG_SUPER_ALLSORT(2295, "游戏管理", "游戏配置-超管", "全部排序"),
    GAMES_CONFIG_SUPER_DELREF(2296, "游戏管理", "游戏配置-超管", "删除分类下游戏"),

    GAMES_CONFIG_COMPANY_LIST(2297, "游戏管理", "游戏配置-总代", "列表"),
    GAMES_CONFIG_COMPANY_ADD(2298, "游戏管理", "游戏配置-总代", "新增"),
    GAMES_CONFIG_COMPANY_EDIT(2299, "游戏管理", "游戏配置-总代", "修改"),
    GAMES_CONFIG_COMPANY_DEL(2300, "游戏管理", "游戏配置-总代", "删除"),
    GAMES_CONFIG_COMPANY_STATUS(2301, "游戏管理", "游戏配置-总代", "状态"),
    GAMES_CONFIG_COMPANY_SCREEN(2302, "游戏管理", "游戏配置-总代", "屏幕方式"),
    GAMES_CONFIG_COMPANY_SORTS(2303, "游戏管理", "游戏配置-总代", "排序"),
    GAMES_CONFIG_COMPANY_IMPORT(2304, "游戏管理", "游戏配置-总代", "导入"),
    GAMES_CONFIG_COMPANY_ALLSORT(2305, "游戏管理", "游戏配置-总代", "全部排序"),
    GAMES_CONFIG_COMPANY_DELREF(2306, "游戏管理", "游戏配置-总代", "删除分类下游戏"),
    GAMES_CONFIG_COMPANY_DELBYGAMETYPE(2307, "游戏管理", "游戏配置-总代", "根据游戏类型删除游戏"),

    GAMES_TYPE_LIST(2308, "游戏管理", "游戏类型", "列表"),
    GAMES_TYPE_ADD(2309, "游戏管理", "游戏类型", "新增"),
    GAMES_TYPE_EDIT(2310, "游戏管理", "游戏类型", "修改"),
    GAMES_TYPE_DEL(2311, "游戏管理", "游戏类型", "删除"),
    GAMES_TYPE_STATUS(2312, "游戏管理", "游戏类型", "状态"),
    GAMES_TYPE_IMPORT(2313, "游戏管理", "游戏类型", "导入"),

    GAMES_CATEGORY_PLATINFO_LIST(2314, "游戏管理", "游戏分类下平台", "列表"),
    GAMES_CATEGORY_PLATINFO_ADD(2315, "游戏管理", "游戏分类下平台", "新增"),
    GAMES_CATEGORY_PLATINFO_EDIT(2316, "游戏管理", "游戏分类下平台", "修改"),
    GAMES_CATEGORY_PLATINFO_DEL(2317, "游戏管理", "游戏分类下平台", "删除"),
    GAMES_CATEGORY_PLATINFO_STATUS(2318, "游戏管理", "游戏分类下平台", "状态"),
    GAMES_CATEGORY_PLATINFO_IMPORT(2319, "游戏管理", "游戏分类下平台", "导入"),


    CASH_WINDOW_CONFIG_LIST(2320, "客户服务", "充值提现弹窗", "列表"),
    CASH_WINDOW_CONFIG_INSERT(2321, "客户服务", "充值提现弹窗", "新增"),
    CASH_WINDOW_CONFIG_UPDATE(2322, "客户服务", "充值提现弹窗", "更新"),
    CASH_WINDOW_CONFIG_DELETE(2323, "客户服务", "充值提现弹窗", "删除"),

    WITHDRAW_BANK_CONFIG_GET(2324, "支付管理", "提现参数配置获取", "查询"),
    ITHDRAW_BANK_CONFIG_SET(2325, "支付管理", "提现参数配置设置", "更新"),

    BANK_MERCHANT_REPORT_SUMMARY(2326, "银商报表", "银商金流汇总", "查询"),
    BANK_MERCHANT_REPORT_RANK(2327, "银商报表", "银商排行", "查询"),
    BANK_MERCHANT_REPORT_CASH_RANK(2328, "银商报表", "玩家进出帐排行", "查询"),
    BANK_MERCHANT_REPORT_SUMMARY_EXPORT(2329, "银商报表", "银商金流汇总导出", "导出"),
    BANK_MERCHANT_REPORT_RANK_EXPORT(2330, "银商报表", "银商排行导出", "导出"),
    BANK_MERCHANT_REPORT_CASH_RANK_EXPORT(2331, "银商报表", "玩家进出帐排行导出", "导出"),
    SUBCONTROL_ABLINE_RECORD(2332, "分控管理", "追杀管理", "查询"),
    //2320
    /**
     * 修改玩家真实姓名
     */
    UPDATE_PALYER_REALNAME(2333, "玩家管理", "玩家列表", "修改玩家真实姓名"),
    /**
     * 游戏房间管理
     */
    GAMES_ROOM_LIST(2340, "游戏房间管理", "游戏房间", "列表"),
    GAMES_ROOM_ADD(2341, "游戏房间管理", "游戏房间", "新增"),
    GAMES_ROOM_EDIT(2342, "游戏房间管理", "游戏房间", "修改"),
    GAMES_ROOM_DEL(2343, "游戏房间管理", "游戏房间", "删除"),


    USDT_DEPOSIT_LIST(2344, "USDT管理", "用户充提记录", "列表"),
    USDT_DEPOSIT_EXPORT(2345, "USDT管理", "用户充提记录", "导出"),
    USDT_ACCOUNT_LIST(2346, "USDT管理", "地址查询", "列表"),
    USDT_ACCOUNT_EXPORT(2347, "USDT管理", "地址查询", "导出"),
    USDT_MERCHANT_LIST(2348, "USDT管理", "USDT商户", "列表"),
    USDT_MERCHANT_ADD(2349, "USDT管理", "USDT商户", "新增"),
    USDT_MERCHANT_EDIT(2350, "USDT管理", "USDT商户", "编辑"),
    USDT_MERCHANT_STATUS(2351, "USDT管理", "USDT商户", "状态"),
    USDT_MERCHANT_DEL(2352, "USDT管理", "USDT商户", "删除"),

    SAVE_PALYER_ADDRPURSE(2353, "玩家管理", "玩家列表", "修改投注钱包地址"),

    HASH_GAME_LOG(2354, "游戏", "hash游戏", "查询hash游戏记录"),
    HASH_GAME_LOG_EXPORT(2355, "游戏", "hash游戏", "hash游戏记录导出"),

    CURRENCY_EXCHANGE_RATE_LIST(2356, "系统设置", "币种汇率", "币种汇率列表"),
    CURRENCY_EXCHANGE_RATE_ADD(2357, "系统设置", "币种汇率", "币种汇率新增"),
    CURRENCY_EXCHANGE_RATE_EDIT(2358, "系统设置", "币种汇率", "币种汇率编辑"),
    CURRENCY_EXCHANGE_RATE_DEL(2359, "系统设置", "币种汇率", "币种汇率删除"),

    PYTHON_SERVER_LIST(2360, "系统设置", "python管理", "服务器列表"),
    PYTHON_SERVER_EXECCMD(2361, "系统设置", "python管理", "执行"),
    PYTHON_SERVER_OPERATE_LOG_LIST(2362, "系统设置", "python管理", "重启日志列表"),

    ;

    private final int type;
    private final String menuFirst;
    private final String menuSecond;
    private final String optPage;


    TraceType(int type, String menuFirst, String menuSecond, String optPage) {
        this.type = type;
        this.menuFirst = menuFirst;
        this.menuSecond = menuSecond;
        this.optPage = optPage;
    }
}
