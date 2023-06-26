package org.sakila.norbs.enums;

public enum TraceOptId {
	None,
	/** session 的 companyId */
	CompanyId,
	/** session 的 ownerId */
	OwnerId,
	/** session 的 playerId */
	PlayerId,
	/** session 的 accountId */
	AccountId,
	/** 请求 的 id（不论是path或request或body） */
	RequestId,
	/** 请求 的 companyId（不论是path或request或body） */
	RequestCompanyId,
	/** 返回 的 id */
	ResponseId,
	;
}
