/* @flavorc
 *
 * MGT.java
 * 
 * This file was automatically generated by flavorc
 * from the source file:
 *     '../FormalDefs/MGT_section.fl'
 *
 * For information on flavorc, visit the Flavor Web site at:
 *     http://flavor.sourceforge.net
 *
 * -- Do not edit by hand --
 *
 */

package flavor.Generated;
import flavor.*;
import java.io.*;

public class MGT {
    int table_id;
    int section_syntax_indicator;
    int private_indicator;
    int reserved1;
    int section_length;
    int table_id_extension;
    int reserved2;
    int version_number;
    int current_next_indicator;
    int section_number;
    int last_section_number;
    int protocol_version;
    int tables_defined;
    int tn;
    MGTTable table;
    int reserved3;
    int descriptors_length;
    int remain_desc_bytes;
    Descriptor descriptor;
    int CRC_32;

    public int get(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        Util.trace(_F_bs.getpos(), 0, (int)0, "begin MGT");
        _F_parse = 8;
        table_id = _F_bs.getbits(_F_parse);
        if (table_id != 199) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ")");
        }
        _F_parse = 1;
        section_syntax_indicator = _F_bs.getbits(_F_parse);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ")");
        }
        _F_parse = 1;
        private_indicator = _F_bs.getbits(_F_parse);
        if (private_indicator != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ")");
        }
        _F_parse = 2;
        reserved1 = _F_bs.getbits(_F_parse);
        if (reserved1 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved1, "reserved1" +  " (" + reserved1 + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved1, "reserved1" +  " (" + reserved1 + ")");
        }
        _F_parse = 12;
        section_length = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_length, "section_length" +  " (" + section_length + ")");
        _F_parse = 16;
        table_id_extension = _F_bs.getbits(_F_parse);
        if (table_id_extension != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id_extension, "table_id_extension" +  " (" + table_id_extension + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id_extension, "table_id_extension" +  " (" + table_id_extension + ")");
        }
        _F_parse = 2;
        reserved2 = _F_bs.getbits(_F_parse);
        if (reserved2 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved2, "reserved2" +  " (" + reserved2 + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved2, "reserved2" +  " (" + reserved2 + ")");
        }
        _F_parse = 5;
        version_number = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)version_number, "version_number" +  " (" + version_number + ")");
        _F_parse = 1;
        current_next_indicator = _F_bs.getbits(_F_parse);
        if (current_next_indicator != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)current_next_indicator, "current_next_indicator" +  " (" + current_next_indicator + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)current_next_indicator, "current_next_indicator" +  " (" + current_next_indicator + ")");
        }
        _F_parse = 8;
        section_number = _F_bs.getbits(_F_parse);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ")");
        }
        _F_parse = 8;
        last_section_number = _F_bs.getbits(_F_parse);
        if (last_section_number != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_number, "last_section_number" +  " (" + last_section_number + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_number, "last_section_number" +  " (" + last_section_number + ")");
        }
        _F_parse = 8;
        protocol_version = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)protocol_version, "protocol_version" +  " (" + protocol_version + ")");
        _F_parse = 16;
        tables_defined = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)tables_defined, "tables_defined" +  " (" + tables_defined + ")");
        for (tn=0; tn<tables_defined; tn++) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing MGTTable table");
            table = new MGTTable();
            _F_ret += table.get(_F_bs);
            if (1==0) break;
        }
        _F_parse = 4;
        reserved3 = _F_bs.getbits(_F_parse);
        if (reserved3 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            _F_ret++;
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved3, "reserved3" +  " (" + reserved3 + ") [ERROR]");
        }
        else {
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved3, "reserved3" +  " (" + reserved3 + ")");
        }
        _F_parse = 12;
        descriptors_length = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)descriptors_length, "descriptors_length" +  " (" + descriptors_length + ")");
        remain_desc_bytes = descriptors_length;
        while (remain_desc_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing Descriptor descriptor");
            descriptor = new Descriptor();
            _F_ret += descriptor.get(_F_bs);
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        _F_parse = 32;
        CRC_32 = _F_bs.getbits(_F_parse);
        Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)CRC_32, "CRC_32" +  " (" + CRC_32 + ")");
        Util.trace(_F_bs.getpos(), 0, (int)0, "end MGT");
        return _F_ret;
    }

    public int put(IBitstream _F_bs) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = 199;
        _F_bs.putbits(table_id, _F_parse);
        _F_parse = 1;
        section_syntax_indicator = 1;
        _F_bs.putbits(section_syntax_indicator, _F_parse);
        _F_parse = 1;
        private_indicator = 1;
        _F_bs.putbits(private_indicator, _F_parse);
        _F_parse = 2;
        reserved1 = 3;
        _F_bs.putbits(reserved1, _F_parse);
        _F_bs.putbits(section_length, 12);
        _F_parse = 16;
        table_id_extension = 0;
        _F_bs.putbits(table_id_extension, _F_parse);
        _F_parse = 2;
        reserved2 = 3;
        _F_bs.putbits(reserved2, _F_parse);
        _F_bs.putbits(version_number, 5);
        _F_parse = 1;
        current_next_indicator = 1;
        _F_bs.putbits(current_next_indicator, _F_parse);
        _F_parse = 8;
        section_number = 0;
        _F_bs.putbits(section_number, _F_parse);
        _F_parse = 8;
        last_section_number = 0;
        _F_bs.putbits(last_section_number, _F_parse);
        _F_bs.putbits(protocol_version, 8);
        _F_bs.putbits(tables_defined, 16);
        for (tn=0; tn<tables_defined; tn++) {
            _F_ret += table.put(_F_bs);
            if (1==0) break;
        }
        _F_parse = 4;
        reserved3 = 15;
        _F_bs.putbits(reserved3, _F_parse);
        _F_bs.putbits(descriptors_length, 12);
        remain_desc_bytes = descriptors_length;
        while (remain_desc_bytes>0) {
            _F_ret += descriptor.put(_F_bs);
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        _F_bs.putbits(CRC_32, 32);
        return _F_ret;
    }

    public int putxml(IBitstream _F_bs, boolean bAttr) throws IOException {
        int _F_ret = 0;
        MapResult _F_mr;
        int _F_parse = 0;
        _F_parse = 8;
        table_id = _F_bs.getbits(_F_parse);
        if (table_id != 199) {
            Util.flerror("Const value mismatch for 'table_id'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<table_id type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            else {
                XML.WriteXmlElement("<table_id bitLen=\"" + _F_parse + "\">" + table_id + "</table_id>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id, "table_id" +  " (" + table_id + ")");
        }
        _F_parse = 1;
        section_syntax_indicator = _F_bs.getbits(_F_parse);
        if (section_syntax_indicator != 1) {
            Util.flerror("Const value mismatch for 'section_syntax_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_syntax_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            else {
                XML.WriteXmlElement("<section_syntax_indicator bitLen=\"" + _F_parse + "\">" + section_syntax_indicator + "</section_syntax_indicator>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_syntax_indicator, "section_syntax_indicator" +  " (" + section_syntax_indicator + ")");
        }
        _F_parse = 1;
        private_indicator = _F_bs.getbits(_F_parse);
        if (private_indicator != 1) {
            Util.flerror("Const value mismatch for 'private_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<private_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            else {
                XML.WriteXmlElement("<private_indicator bitLen=\"" + _F_parse + "\">" + private_indicator + "</private_indicator>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)private_indicator, "private_indicator" +  " (" + private_indicator + ")");
        }
        _F_parse = 2;
        reserved1 = _F_bs.getbits(_F_parse);
        if (reserved1 != 3) {
            Util.flerror("Const value mismatch for 'reserved1'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
            else {
                XML.WriteXmlElement("<reserved1 bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<reserved1 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
            else {
                XML.WriteXmlElement("<reserved1 bitLen=\"" + _F_parse + "\">" + reserved1 + "</reserved1>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved1, "reserved1" +  " (" + reserved1 + ")");
        }
        _F_parse = 12;
        section_length = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<section_length type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        else {
            XML.WriteXmlElement("<section_length bitLen=\"" + _F_parse + "\">" + section_length + "</section_length>");
        }
        _F_parse = 16;
        table_id_extension = _F_bs.getbits(_F_parse);
        if (table_id_extension != 0) {
            Util.flerror("Const value mismatch for 'table_id_extension'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
            else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<table_id_extension type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
            else {
                XML.WriteXmlElement("<table_id_extension bitLen=\"" + _F_parse + "\">" + table_id_extension + "</table_id_extension>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)table_id_extension, "table_id_extension" +  " (" + table_id_extension + ")");
        }
        _F_parse = 2;
        reserved2 = _F_bs.getbits(_F_parse);
        if (reserved2 != 3) {
            Util.flerror("Const value mismatch for 'reserved2'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
            else {
                XML.WriteXmlElement("<reserved2 bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<reserved2 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
            else {
                XML.WriteXmlElement("<reserved2 bitLen=\"" + _F_parse + "\">" + reserved2 + "</reserved2>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved2, "reserved2" +  " (" + reserved2 + ")");
        }
        _F_parse = 5;
        version_number = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<version_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
        }
        else {
            XML.WriteXmlElement("<version_number bitLen=\"" + _F_parse + "\">" + version_number + "</version_number>");
        }
        _F_parse = 1;
        current_next_indicator = _F_bs.getbits(_F_parse);
        if (current_next_indicator != 1) {
            Util.flerror("Const value mismatch for 'current_next_indicator'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
            else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<current_next_indicator type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
            else {
                XML.WriteXmlElement("<current_next_indicator bitLen=\"" + _F_parse + "\">" + current_next_indicator + "</current_next_indicator>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)current_next_indicator, "current_next_indicator" +  " (" + current_next_indicator + ")");
        }
        _F_parse = 8;
        section_number = _F_bs.getbits(_F_parse);
        if (section_number != 0) {
            Util.flerror("Const value mismatch for 'section_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            else {
                XML.WriteXmlElement("<section_number bitLen=\"" + _F_parse + "\">" + section_number + "</section_number>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)section_number, "section_number" +  " (" + section_number + ")");
        }
        _F_parse = 8;
        last_section_number = _F_bs.getbits(_F_parse);
        if (last_section_number != 0) {
            Util.flerror("Const value mismatch for 'last_section_number'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
            else {
                XML.WriteXmlElement("<last_section_number bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<last_section_number type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
            else {
                XML.WriteXmlElement("<last_section_number bitLen=\"" + _F_parse + "\">" + last_section_number + "</last_section_number>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)last_section_number, "last_section_number" +  " (" + last_section_number + ")");
        }
        _F_parse = 8;
        protocol_version = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<protocol_version type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + protocol_version + "</protocol_version>");
        }
        else {
            XML.WriteXmlElement("<protocol_version bitLen=\"" + _F_parse + "\">" + protocol_version + "</protocol_version>");
        }
        _F_parse = 16;
        tables_defined = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<tables_defined type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + tables_defined + "</tables_defined>");
        }
        else {
            XML.WriteXmlElement("<tables_defined bitLen=\"" + _F_parse + "\">" + tables_defined + "</tables_defined>");
        }
        for (tn=0; tn<tables_defined; tn++) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing MGTTable table");
            table = new MGTTable();
            XML.IntoAClass("table", 0);
            _F_ret += table.putxml(_F_bs, bAttr);
            XML.OutOfClass("</table>");
            if (1==0) break;
        }
        _F_parse = 4;
        reserved3 = _F_bs.getbits(_F_parse);
        if (reserved3 != 15) {
            Util.flerror("Const value mismatch for 'reserved3'");
            _F_ret++;
            if (bAttr) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved3 + "</reserved3>");
            }
            else {
                XML.WriteXmlElement("<reserved3 bitLen=\"" + _F_parse + "\">" + reserved3 + "</reserved3>");
            }
        }
        else {
            if (bAttr) {
                XML.WriteXmlElement("<reserved3 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + reserved3 + "</reserved3>");
            }
            else {
                XML.WriteXmlElement("<reserved3 bitLen=\"" + _F_parse + "\">" + reserved3 + "</reserved3>");
            }
            Util.trace(_F_bs.getpos()-_F_parse, _F_parse, (int)reserved3, "reserved3" +  " (" + reserved3 + ")");
        }
        _F_parse = 12;
        descriptors_length = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<descriptors_length type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + descriptors_length + "</descriptors_length>");
        }
        else {
            XML.WriteXmlElement("<descriptors_length bitLen=\"" + _F_parse + "\">" + descriptors_length + "</descriptors_length>");
        }
        remain_desc_bytes = descriptors_length;
        while (remain_desc_bytes>0) {
            Util.trace(_F_bs.getpos(), 0, (int)0, "processing Descriptor descriptor");
            descriptor = new Descriptor();
            XML.IntoAClass("descriptor", 0);
            _F_ret += descriptor.putxml(_F_bs, bAttr);
            XML.OutOfClass("</descriptor>");
            remain_desc_bytes-=(descriptor._F_lengthof/8);
            if (1==0) break;
        }
        _F_parse = 32;
        CRC_32 = _F_bs.getbits(_F_parse);
        if (bAttr) {
            XML.WriteXmlElement("<CRC_32 type=\"flUInt\" bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        else {
            XML.WriteXmlElement("<CRC_32 bitLen=\"" + _F_parse + "\">" + CRC_32 + "</CRC_32>");
        }
        return _F_ret;
    }
}
