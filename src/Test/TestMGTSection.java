/**
 * 
 */
package Test;

import java.io.FileOutputStream;
import java.io.IOException;

import API.SITableFactory;
import API.Section;
import API.TableType;
import flavor.BuffBitstream;
import flavor.IBitstream;

/**
 * @author SungHun Park (dr.superchamp@gmail.com)
 *
 */
public class TestMGTSection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* This example is to show how to verify your implementation of SI tables
		 *  by using 'flavor'(Formal Language for Audio-Visual Object Representation).
		 */
		API.PSIP.TVCT tvct;
		API.PSIP.MGT table;
		int tvct_ver = 0x5, mgt_ver = 0x12;
		int tsid = 0xABC;
		
		tvct = SITableFactory.createTVCT(tvct_ver, tsid);
		table = SITableFactory.createMGT(mgt_ver);
		table.addTable(SITableFactory.createMGTTable(TableType.Terrestrial_VCT_with_current_next_indicator_1, tvct.getTablePID(),
				tvct.getTableVersion(), 0/* don no this-_-*/));
		
		Section [] sections = table.toSection();
		for(int sn=0; sn < sections.length; sn++) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream("temp", false);
				fos.write(sections[sn].getSectionBytes());
				fos.close();

				IBitstream stream = new BuffBitstream("temp", IBitstream.BS_INPUT);
				flavor.Generated.MGT parser = new flavor.Generated.MGT();
				parser.get(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
