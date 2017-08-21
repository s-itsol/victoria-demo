/**
 *
 */
package net.sitsol.victoria.demo.facades;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sitsol.victoria.demo.beans.cond.DemoSearchCond;
import net.sitsol.victoria.demo.beans.dto.DemoDto;
import net.sitsol.victoria.demo.models.demo.DemoModel;

/**
 * デモマスタ用ファサード
 *
 * @author shibano
 */
public class DemoMasterFacade {

	// TODO：DBアクセスはまだなので、仮想レコードリストを手動で生成
	private static List<DemoModel> virtualRecordList_ = new ArrayList<>();
	{
		String[][] recordsArray = {
			  {"10000001", "ファー付きコート", "ファー付きコートは、" + System.lineSeparator() + "ファーが付いた冬物のコート"}
			, {"10000002", "ドルマンTシャツ", "ドルマンTシャツは、" + System.lineSeparator() + "ドルマンカットのTシャツ"}
			, {"10000003", "アシンメトリーパーカー", "アシンメトリーパーカーは、" + System.lineSeparator() + "左右非対称なパーカー"}
		};

		for ( String[] records : recordsArray ) {

			DemoModel model = new DemoModel();
			model.setDemoId(records[0]);
			model.setDemoName(records[1]);
			model.setDemoDetail(records[2]);

			virtualRecordList_.add(model);
		}
	}

	private static DemoMasterFacade instance_ = new DemoMasterFacade();

	/**
	 * インスタンス取得
	 * @return このクラスのインスタンス
	 */
	public static DemoMasterFacade getInstance() {
		return instance_;
	}

	/**
	 * デフォルトコンストラクタ ※外部からはインスタンス化させない
	 */
	protected DemoMasterFacade() { }

	/**
	 * デモDTO一覧検索
	 * @param cond デモ検索条件ビーン
	 * @return デモDTOリスト
	 */
	public List<DemoDto> searchDemoDtoList(DemoSearchCond cond) {

		// 一覧検索実行 TODO：DBアクセスはまだなので、仮想レコードリストを返す
		List<DemoDto> dtoList = new ArrayList<>();

		for ( DemoModel model : virtualRecordList_ ) {

			DemoDto dto = new DemoDto();
			dto.setDemoId(model.getDemoId());
			dto.setDemoName(model.getDemoName());

			dtoList.add(dto);
		}

		return dtoList;
	}

	/**
	 * デモモデル１件検索
	 * @param demoId デモID
	 * @return デモモデル
	 */
	public DemoModel findDemoModel(String demoId) {

		System.out.println("★更新対象-demoId：[" + demoId + "]");

		DemoModel retModel = null;

		// TODO：DBアクセスはまだなので、仮想レコードの値をコピーしたモデルを生成して返す
		for ( DemoModel demoModel : virtualRecordList_ ) {

			if ( StringUtils.equals(demoId, demoModel.getDemoId()) ) {
				retModel = new DemoModel();
				retModel.setDemoId(demoModel.getDemoId());
				retModel.setDemoName(demoModel.getDemoName());
				retModel.setDemoDetail(demoModel.getDemoDetail());
				break;
			}
		}

		return retModel;
	}

	/**
	 * デモモデル１件更新
	 * @param updDemoModel デモモデル
	 */
	public void updateDemoModel(DemoModel updDemoModel) {

		System.out.println("★更新後内容↓↓↓");
		System.out.println(updDemoModel.getDemoId() + "「" + updDemoModel.getDemoName() + "」");
		System.out.println(updDemoModel.getDemoDetail());
		System.out.println("ここまでが更新後内容↑↑↑");

		// TODO：DBアクセスはまだなので、IDが一致した仮想レコードの値を上書きコピーする
		for ( DemoModel demoModel : virtualRecordList_ ) {

			if ( StringUtils.equals(updDemoModel.getDemoId(), demoModel.getDemoId()) ) {
				demoModel.setDemoId(updDemoModel.getDemoId());
				demoModel.setDemoName(updDemoModel.getDemoName());
				demoModel.setDemoDetail(updDemoModel.getDemoDetail());
				break;
			}
		}
	}

}
