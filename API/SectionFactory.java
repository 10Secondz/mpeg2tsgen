package API;

import Core.SectionDefaultImpl;
/**
 * 
 */

/**
 * @author SungHun Park (sainthh@tvstorm.com)
 *
 */
public class SectionFactory {

	public static Section createPATSection(SITable table, int transport_stream_id,
			int section_num, int last_section_num) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(0);
		section.setTableIdExtension(transport_stream_id);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(section_num);
		section.setLastSectionNumber(last_section_num);
		return section;
	}

	public static Section createPMTSection(SITable table, int program_number) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(0);
		section.setTableIdExtension(program_number);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		// PMT is a single section
		section.setSectionNumber(0);
		section.setLastSectionNumber(0);
		return section;
	}
	
	public static Section createMGTSection(SITable table) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3); //
		section.setTableIdExtension(0x0000);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		// MGT is a single section
		section.setSectionNumber(0);
		section.setLastSectionNumber(0);
		return section;
	}

	public static Section createTVCTSection(SITable table, int transport_stream_id,
			int section_num, int last_section_num) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3); //
		section.setTableIdExtension(transport_stream_id);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(section_num);
		section.setLastSectionNumber(last_section_num);
		return section;
	}
	
	public static Section createCVCTSection(SITable table, int transport_stream_id,
			int section_num, int last_section_num) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3); //
		section.setTableIdExtension(transport_stream_id);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(section_num);
		section.setLastSectionNumber(last_section_num);
		return section;
	}
	
	public static Section createSTTSection(SITable table) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3); //	
		section.setTableIdExtension(0x0000);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(0);
		section.setLastSectionNumber(0);
		return section;
	}
	
	public static Section createRRTSection(SITable table, int rating_region,
			int section_num, int last_section_num) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3);
		section.setTableIdExtension((0xFF<<8)|rating_region);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(section_num);
		section.setLastSectionNumber(last_section_num);
		return section;
	}
	
	public static Section createEITSection(SITable table, int source_id,
			int section_num, int last_section_num) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3);
		section.setTableIdExtension(source_id);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		section.setSectionNumber(section_num);
		section.setLastSectionNumber(last_section_num);
		return section;
	}
	
	public static Section createETTSection(SITable table, int table_id_extension) {
		Section section = new SectionDefaultImpl(table, 1);
		section.setPrivateIndicator(1);
		section.setReserved1(0x3);
		section.setTableIdExtension(table_id_extension);
		section.setReserved2(0x3);
		section.setVersionNumber(table.getTableVersion());
		section.setCurrentNextIndicator(1); // default is current!
		return section;
	}
}
