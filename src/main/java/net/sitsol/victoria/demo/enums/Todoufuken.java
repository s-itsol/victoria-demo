package net.sitsol.victoria.demo.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sitsol.victoria.enums.VctEnumAccessible;

/**
 * victoriaデモ用-Enum定数「都道府県」
 * 
 * @author vitoria-type-src-generater
 */
public enum Todoufuken implements VctEnumAccessible {

	/** 北海道 ※01：北海道 */
	Hokkaido("01", "北海道")
	,
	/** 青森県 ※02：青森県 */
	Aomori("02", "青森県")
	,
	/** 岩手県 ※03：岩手県 */
	Iwate("03", "岩手県")
	,
	/** 宮城県 ※04：宮城県 */
	Miyagi("04", "宮城県")
	,
	/** 秋田県 ※05：秋田県 */
	Akita("05", "秋田県")
	,
	/** 山形県 ※06：山形県 */
	Yamagata("06", "山形県")
	,
	/** 福島県 ※07：福島県 */
	Fukushima("07", "福島県")
	,
	/** 茨城県 ※08：茨城県 */
	Ibaraki("08", "茨城県")
	,
	/** 栃木県 ※09：栃木県 */
	Tochigi("09", "栃木県")
	,
	/** 群馬県 ※10：群馬県 */
	Gunma("10", "群馬県")
	,
	/** 埼玉県 ※11：埼玉県 */
	Saitama("11", "埼玉県")
	,
	/** 千葉県 ※12：千葉県 */
	Chiba("12", "千葉県")
	,
	/** 東京都 ※13：東京都 */
	Tokyo("13", "東京都")
	,
	/** 神奈川県 ※14：神奈川県 */
	Kanagawa("14", "神奈川県")
	,
	/** 新潟県 ※15：新潟県 */
	Niigata("15", "新潟県")
	,
	/** 富山県 ※16：富山県 */
	Toyama("16", "富山県")
	,
	/** 石川県 ※17：石川県 */
	Ishikawa("17", "石川県")
	,
	/** 福井県 ※18：福井県 */
	Fukui("18", "福井県")
	,
	/** 山梨県 ※19：山梨県 */
	Yamanashi("19", "山梨県")
	,
	/** 長野県 ※20：長野県 */
	Nagano("20", "長野県")
	,
	/** 岐阜県 ※21：岐阜県 */
	Gifu("21", "岐阜県")
	,
	/** 静岡県 ※22：静岡県 */
	Shizuoka("22", "静岡県")
	,
	/** 愛知県 ※23：愛知県 */
	Aichi("23", "愛知県")
	,
	/** 三重県 ※24：三重県 */
	Mie("24", "三重県")
	,
	/** 滋賀県 ※25：滋賀県 */
	Shiga("25", "滋賀県")
	,
	/** 京都府 ※26：京都府 */
	Kyoto("26", "京都府")
	,
	/** 大阪府 ※27：大阪府 */
	Osaka("27", "大阪府")
	,
	/** 兵庫県 ※28：兵庫県 */
	Hyogo("28", "兵庫県")
	,
	/** 奈良県 ※29：奈良県 */
	Nara("29", "奈良県")
	,
	/** 和歌山県 ※30：和歌山県 */
	Wakayama("30", "和歌山県")
	,
	/** 鳥取県 ※31：鳥取県 */
	Tottori("31", "鳥取県")
	,
	/** 島根県 ※32：島根県 */
	Shimane("32", "島根県")
	,
	/** 岡山県 ※33：岡山県 */
	Okayama("33", "岡山県")
	,
	/** 広島県 ※34：広島県 */
	Hiroshima("34", "広島県")
	,
	/** 山口県 ※35：山口県 */
	Yamaguchi("35", "山口県")
	,
	/** 徳島県 ※36：徳島県 */
	Tokushima("36", "徳島県")
	,
	/** 香川県 ※37：香川県 */
	Kagawa("37", "香川県")
	,
	/** 愛媛県 ※38：愛媛県 */
	Ehime("38", "愛媛県")
	,
	/** 高知県 ※39：高知県 */
	Kochi("39", "高知県")
	,
	/** 福岡県 ※40：福岡県 */
	Fukuoka("40", "福岡県")
	,
	/** 佐賀県 ※41：佐賀県 */
	Saga("41", "佐賀県")
	,
	/** 長崎県 ※42：長崎県 */
	Nagasaki("42", "長崎県")
	,
	/** 熊本県 ※43：熊本県 */
	Kumamoto("43", "熊本県")
	,
	/** 大分県 ※44：大分県 */
	Oita("44", "大分県")
	,
	/** 宮崎県 ※45：宮崎県 */
	Miyazaki("45", "宮崎県")
	,
	/** 鹿児島県 ※46：鹿児島県 */
	Kagoshima("46", "鹿児島県")
	,
	/** 沖縄県 ※47：沖縄県 */
	Okinawa("47", "沖縄県")
	;

	/**
	 * 全型リスト取得
	 *  ※読取専用で使う際には、暗黙の静的メソッド「values()」の方が若干軽量なのだが、
	 *    「10万回実行したら、30～80msほど遅かった」程度だったので、「ほぼ劣化は無し」という見立て。
	 *    かつ、eclipseの「呼び出し階層を開く」の検索対象にでき、調査／保守の観点からも、
	 *    アプリでは常にこちらの使用を推奨する。
	 */
	public static List<Todoufuken> getAllTypeList() {
		return new ArrayList<>( Arrays.asList(Todoufuken.values()) );
	}

	/**
	 * 型取得
	 * @param code コード値
	 * @return 型 ※該当なしの場合はnull
	 */
	public static Todoufuken getType(String code) {
		
		Todoufuken retEnumType = null;
		
		// 型ループ
		for ( Todoufuken enumType : Todoufuken.values() ) {
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
//		return Arrays.stream(Todoufuken.values())
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
		Todoufuken targetType = getType(code);
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
	private Todoufuken(String code, String decode) {
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
