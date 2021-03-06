package net.sitsol.victoria.demo.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sitsol.victoria.enums.VctEnumAccessible;

/**
 * victoriaデモ用-Enum定数「フラグ」
 * 
 * @author vitoria-type-src-generater
 */
public enum Flag implements VctEnumAccessible {

	/** 偽 ※0：OFF */
	Off("0", "OFF")
	,
	/** 真 ※1：ON */
	On("1", "ON")
	;

	/**
	 * 全型リスト取得
	 *  ※読取専用で使う際には、暗黙の静的メソッド「values()」の方が若干軽量なのだが、
	 *    「10万回実行したら、30～80msほど遅かった」程度だったので、「ほぼ劣化は無し」という見立て。
	 *    かつ、eclipseの「呼び出し階層を開く」の検索対象にでき、調査／保守の観点からも、
	 *    アプリでは常にこちらの使用を推奨する。
	 */
	public static List<Flag> getAllTypeList() {
		return new ArrayList<>( Arrays.asList(Flag.values()) );
	}

	/**
	 * 型取得
	 * @param code コード値
	 * @return 型 ※該当なしの場合はnull
	 */
	public static Flag getType(String code) {
		
		Flag retEnumType = null;
		
		// 型ループ
		for ( Flag enumType : Flag.values() ) {
			// コード値が一致したら、戻り値として確定
			if ( enumType.getCode().equals(code) ) {
				retEnumType = enumType;
				break;
			}
		}
		
		return retEnumType;
		
		// ※参考までに、ラムダ式でコーディングするなら以下。
		//   …なのだが、既に配列は生成済みなので、streamの効果は出ないはず。。
		//   であれば、わざわざJAVA8未満で動かないソースを生成させる理由も無い…という判断。
//		return Arrays.stream(Flag.values())
//					.filter( enumType -> enumType.getCode().equals(code) )
//					.findFirst()
//					.orElse(null)
//		; 
	}

	/**
	 * デコード文字列取得
	 * @param code コード値
	 * @return デコード文字列 ※該当なしの場合は空文字
	 */
	public static String getDecode(String code) {
		Flag targetType = getType(code);
		return targetType != null ? targetType.getDecode() : "";
	}

	/** コード値 */
	private final String code;
	/** デコード文字列 */
	private final String decode;

	/**
	 * コンストラクタ
	 * @param code コード値
	 * @param decode デコード文字列
	 */
	private Flag(String code, String decode) {
		this.code = code;
		this.decode = decode;
	}

	/**
	 * コード値
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * デコード文字列
	 */
	@Override
	public String getDecode() {
		return this.decode;
	}

}
