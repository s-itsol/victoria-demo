/**
 * 
 */
package enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import demotools.BsDemoExecute;
import net.sitsol.victoria.demo.enums.Todoufuken;
import net.sitsol.victoria.demo.enums.sys.SiteDiv;
import net.sitsol.victoria.enums.VctEnumAccessible;
import net.sitsol.victoria.utils.statics.VctStringUtils;

/**
 * Enum定数-プログラミング使用例
 *  ※Enum定数は「victoria-type-src-generater」で生成したソース
 * 
 * @author shibano
 */
public class EnumDemo extends BsDemoExecute {

	private final static Map<String, Todoufuken> codeTypeMap_;
	static {
		Todoufuken[] allTypes = Todoufuken.values();
		
		codeTypeMap_ = new LinkedHashMap<String, Todoufuken>(allTypes.length);
		for ( Todoufuken enumType : allTypes ) {
			codeTypeMap_.put(enumType.getCode(), enumType);
		}
	}

	/**
	 * メインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// メソッド実行要求
		EnumDemo.doExecute(new EnumDemo(), false, args);
	}

	/**
	 * Enum定数テスト
	 */
	@Override
	protected void execute(String[] args) {
		// 性能テスト
		this.execTimeTest();
		// 使用例
		this.demo();
	}

	/**
	 * 性能テスト
	 */
	private void execTimeTest() {
		
		int execCount = 100000;
		long millis;
		
		{
			// 計測前に10回ずつ実行させておく
			millis = this.loopTypeValues(10);
			millis = this.loopGetAllTypeList(10);
			
			System.out.println("----------------------------------------------------------------------");
			System.out.println("各処理測定開始 - 実行回数：[" + execCount + "]");
			
			millis = this.loopTypeValues(execCount);
			System.out.println(" - 実行時間：[" + millis + "], 「型配列」");
			
			millis = this.loopGetAllTypeList(execCount);
			System.out.println(" - 実行時間：[" + millis + "], 「型リスト取得」");
			
			System.out.println("各処理測定終了");
			System.out.println("----------------------------------------------------------------------");
			
			// 内容確認
			Todoufuken[] types = Todoufuken.values();
			List<Todoufuken> typeList = Todoufuken.getAllTypeList();
			
			if ( types.length != typeList.size() ) {
				throw new RuntimeException("▲配列／リストで要素数が異なる");
			}
			
			for ( int idx = 0; idx < types.length; idx++ ) {
				Todoufuken type1 = types[idx];
				Todoufuken type2 = typeList.get(idx);
				
				if ( !type1.getCode().equals(type2.getCode())
					|| !type1.getDecode().equals(type2.getDecode())
					|| !type1.equals(type2)
				) {
					throw new RuntimeException("▲配列／リストで順番が異なる？"
							+ "インデックス：[" + idx + "]"
							+ ", 型(配列／リスト)：[" + type1 + "／" + type2 + "]"
					);
				}
			}
			
//			// 目検用
//			millis = this.loopTypeValues(1);
//			millis = this.loopGetAllTypeList(1);
//			System.out.println("----------------------------------------------------------------------");
		}
		
		{
			final String code = "47";
			
			// 計測前に10回ずつ実行させておく
			millis = this.loopGetMapType(code, 10);
			millis = this.loopSeqSearchType(code, 10);
			
			System.out.println("----------------------------------------------------------------------");
			System.out.println("各処理測定開始 - 実行回数：[" + execCount + "]");
			
			millis = this.loopGetMapType(code, 10);
			System.out.println(" - 実行時間：[" + millis + "], 「静的なマップインスタンスから取得」");
			
			millis = this.loopSeqSearchType(code, 10);
			System.out.println(" - 実行時間：[" + millis + "], 「配列から順次探索」");
			
			System.out.println("各処理測定終了");
			System.out.println("----------------------------------------------------------------------");
			
			// 内容確認
			millis = this.loopGetMapType(code, 1);
			millis = this.loopSeqSearchType(code, 1);
			System.out.println("----------------------------------------------------------------------");
		}
	}

	private long loopTypeValues(int execCount) {
		
		long startMillis = System.currentTimeMillis();
		
		for ( int idx = 0; idx < execCount; idx++ ) {
			// 全型のループ
			for ( Todoufuken enumType : Todoufuken.values() ) {
				String code = enumType.getCode();
				String decode = enumType.getDecode();
				
				if ( execCount <= 1 ) {
					System.out.println(code + ":" + decode);
				}
			}
		}
		
		return System.currentTimeMillis() - startMillis;
	}

	private long loopGetAllTypeList(int execCount) {
		
		long startMillis = System.currentTimeMillis();
		
		for ( int idx = 0; idx < execCount; idx++ ) {
			// 全型のループ
			for ( Todoufuken enumType : Todoufuken.getAllTypeList() ) {
				String code = enumType.getCode();
				String decode = enumType.getDecode();
				
				if ( execCount <= 1 ) {
					System.out.println(code + ":" + decode);
				}
			}
		}
		
		return System.currentTimeMillis() - startMillis;
	}

	private long loopGetMapType(String targetCode, int execCount) {
		
		long startMillis = System.currentTimeMillis();
		
		for ( int idx = 0; idx < execCount; idx++ ) {
			Todoufuken type = codeTypeMap_.get(targetCode);
			
			if ( execCount <= 1 ) {
				System.out.println("[" + type + "] - " + type.getCode() + ":" + type.getDecode());
			}
		}
		
		return System.currentTimeMillis() - startMillis;
	}

	private long loopSeqSearchType(String targetCode, int execCount) {
		
		long startMillis = System.currentTimeMillis();
		
		for ( int idx = 0; idx < execCount; idx++ ) {
			Todoufuken type = null;
			
			for ( Todoufuken enumType : Todoufuken.values() ) {
				if ( targetCode.equals(enumType.getCode()) ) {
					type = enumType;
					break;
				}
			}
			
			if ( execCount <= 1 ) {
				System.out.println("[" + type + "] - " + type.getCode() + ":" + type.getDecode());
			}
		}
		
		return System.currentTimeMillis() - startMillis;
	}

	/**
	 * 使用例
	 */
	private void demo() {
		
		// 定数として使う
		System.out.println(Todoufuken.Tokyo + "のEnum情報"
								+ " -> [" + Todoufuken.Tokyo.getCode() + ":" + Todoufuken.Tokyo.getDecode() + "]"
		);
		
		// コード値から型／デコード文字列を得る
		final String[] targetCodes = { "13", "48", "", null };
		for ( String targetCode : targetCodes ) {
			System.out.println("コード値：[" + targetCode+ "]のデコード文字列／Enum型"
								+ " -> [" + Todoufuken.getDecode(targetCode) + "／" + Todoufuken.getType(targetCode) + "]"
			);
		}
		
		// 全型リストを得る
		List<SiteDiv> enumTypeList = SiteDiv.getAllTypeList();
		System.out.println("Enum型：[" + SiteDiv.class.getSimpleName() + "]の全型リスト↓");
		for ( VctEnumAccessible enumType : enumTypeList ) {
			System.out.println(" -> [" + enumType + "]");
		}
		
		// 任意の1件を追加するよう加工
		SiteDiv addEnum = SiteDiv.PersonalComputer;
		enumTypeList.add(addEnum);
		System.out.println("Enum型：[" + SiteDiv.class.getSimpleName() + "]へ、さらに[" + addEnum + "]を追加した型リスト↓");
		for ( VctEnumAccessible enumType : enumTypeList ) {
			System.out.println(" -> [" + enumType + "]");
		}
	}

}
