// Trabalho Prático 3 - Mateus de Jesus Santos - 22152028

import java.util.*; // // Biblioteca que fornece classes para estruturas de dados, coleções e utilitários.

public class AlgoritmosTrocaPaginas {
    public static void main(String[] args) {
    	System.out.println("O tamanho do vetor foi definido para 1000 posições na linha 10 do código \n"
    			+ "e as entradas de teste utilizadas são as que foram disponibilizadas no colabweb.\n");
    	
        int tamVetMen = 1000; // tamanho do vetor da memória
        // String com as entradas de teste que foi disponibilizada no Colabweb
        String stringDeEntradas = "4,1065;2,74;3,837;3,312;1,369;6,1571;1,1188;8,530;6,1594;4,1995;8,448;6,1139;5,769;3,1520;8,1224;5,1412;4,736;1,613;5,1734;5,1414;5,323;7,94;7,985;7,1439;7,1111;3,326;5,1317;8,28;1,1442;6,1039;3,438;5,145;8,1851;3,73;7,869;8,1044;2,1254;5,457;2,1085;4,1817;7,696;3,996;4,1415;6,1561;1,1672;6,1705;6,1155;8,561;5,479;3,153;5,1112;4,823;4,1255;7,1980;4,175;2,770;4,1831;2,551;7,1313;1,1855;8,698;8,897;2,1730;7,275;7,1894;7,1847;1,1733;7,974;3,1734;6,1381;2,1227;1,1524;7,875;8,13;8,1516;8,457;8,1283;5,1175;6,1489;7,75;5,244;3,269;2,1042;8,1690;8,653;7,1292;4,958;8,1735;7,384;6,1617;2,1253;4,119;5,1604;4,1708;8,1360;2,1646;2,1524;8,1281;7,1340;1,1301;2,1086;2,609;4,1614;1,626;2,1739;8,1347;7,1586;6,1374;3,468;4,1523;4,808;7,100;3,1863;8,1951;2,184;7,1263;8,1075;1,630;6,1060;6,910;5,1092;2,1293;5,835;6,1927;2,1829;1,564;8,1074;6,1325;6,1126;2,809;6,1960;4,1962;2,821;8,1031;1,1189;5,1564;1,625;8,1813;5,304;7,869;5,626;7,553;8,751;4,145;7,1825;4,1915;4,1778;1,1318;2,1164;2,1635;6,630;5,1375;2,1111;7,1520;2,332;7,1684;6,1929;1,1684;5,1647;2,1285;3,1346;5,751;5,1670;2,214;5,1392;3,1998;2,1791;6,1329;7,1803;5,1065;5,646;6,88;7,1398;5,1107;7,973;4,1161;1,1482;2,1917;2,1105;7,734;6,356;2,817;7,188;2,1797;2,1628;1,748;4,1038;2,670;7,1055;5,1240;6,1844;1,475;6,1288;4,639;2,1814;4,1210;7,895;4,1139;2,113;8,535;4,1685;2,1927;1,341;3,343;5,369;6,1890;3,88;7,1619;2,1243;7,93;7,932;6,82;4,1582;6,1387;6,585;8,1506;5,1073;7,255;1,1728;4,620;2,652;5,183;2,1370;2,904;3,723;6,544;8,448;5,577;7,1771;4,200;7,1649;5,500;5,17;5,717;3,320;5,687;1,771;5,306;3,629;5,1586;4,789;4,285;4,970;7,193;2,1971;8,1080;8,951;6,1576;7,316;2,485;3,1107;3,1303;1,164;2,1071;7,1824;8,1718;2,288;2,406;7,1800;6,996;2,1512;5,864;6,654;2,320;3,1094;2,1583;6,1175;3,1499;1,1184;1,1279;3,1999;1,806;3,1265;4,1362;8,1325;1,739;3,1549;6,1988;8,649;1,1901;5,1872;4,1368;3,263;6,100;7,735;4,901;6,1652;8,1277;6,1690;4,1361;2,1719;2,778;7,1357;5,585;5,90;2,1954;3,952;7,821;8,1607;3,56;7,1242;5,80;2,1426;4,774;3,1492;5,557;4,1954;4,813;5,1951;5,381;7,1230;7,270;8,1104;2,652;8,1122;2,1580;2,916;1,1932;4,1101;8,1235;1,1912;7,1067;1,1131;3,440;4,1008;5,412;6,1583;2,1297;3,580;3,1213;4,880;4,112;6,1338;8,1164;7,912;5,820;5,164;1,790;2,114;5,1506;3,1116;2,544;2,385;7,1453;6,1426;4,230;2,903;6,1079;3,364;1,516;8,1169;5,616;3,1412;3,1039;6,1487;5,1290;1,1320;8,817;1,1377;4,1258;2,1119;4,346;6,1275;4,1481;2,322;1,992;7,193;8,182;5,55;1,1996;7,1816;8,484;2,1993;3,597;2,1896;8,270;3,1507;5,470;8,562;1,281;1,1546;7,1926;4,564;5,1892;1,329;3,1967;4,225;4,1999;8,1010;2,1530;1,283;8,841;1,1066;4,948;6,544;2,1609;6,1203;6,854;7,1683;7,89;8,218;6,457;7,1284;5,569;2,1245;7,328;2,1595;8,678;3,471;2,540;6,1259;5,788;3,1445;5,1186;4,649;3,1064;3,684;4,1054;1,215;1,1183;3,1364;1,1355;1,1638;7,222;2,1475;2,1210;5,363;8,1156;4,862;6,1710;7,1436;7,1832;6,194;6,127;7,399;8,313;5,1951;4,1023;1,1309;6,841;7,1104;2,736;5,799;2,1712;3,1261;7,1894;4,403;1,1737;8,584;8,1337;3,1213;8,1974;1,931;7,10;7,1251;2,1827;6,1164;5,1119;3,781;3,1572;4,1744;4,1008;5,94;1,850;8,210;6,1959;7,159;3,579;5,310;1,1287;1,821;3,215;2,1058;2,817;8,89;1,1238;3,112;1,1055;3,1370;2,1200;6,428;5,1019;2,1321;8,611;8,232;5,1949;5,1365;8,1407;8,1917;5,782;4,679;6,675;8,1567;6,1515;8,1839;3,801;8,1383;2,1239;2,128;7,1119;6,343;6,876;2,1818;8,619;8,47;2,322;7,1597;8,210;6,742;1,1905;6,611;2,503;8,1105;5,797;3,431;8,1006;4,466;2,190;8,601;3,1124;8,1683;5,758;6,221;1,234;1,1027;8,144;3,1352;8,1646;5,1926;7,904;6,1891;5,1152;8,596;8,530;4,1845;1,1323;2,1059;3,909;7,1797;2,1714;2,1221;8,742;4,1662;7,536;7,201;5,1186;6,1684;4,1328;1,204;8,145;8,1916;2,619;1,1786;8,381;2,1305;8,1537;3,1491;5,787;3,760;3,1726;5,1349;3,882;4,509;8,1940;1,847;7,1792;5,261;7,113;1,1551;3,675;3,1623;6,643;5,645;7,1756;8,1482;3,109;7,200;5,1854;4,922;2,577;3,100;8,1449;4,558;7,99;8,120;6,96;3,17;4,982;4,714;7,1136;4,593;3,1835;3,661;8,1410;5,1968;5,1370;5,800;1,843;3,189;1,383;3,660;5,489;7,929;2,1286;6,849;5,1853;1,1410;5,24;6,687;2,944;3,140;3,1169;3,1592;5,1784;2,13;8,1409;5,363;4,1777;4,1089;6,1643;7,532;6,1517;3,736;5,1304;8,573;4,371;5,636;7,528;7,799;6,324;5,467;8,203;5,399;8,317;1,934;1,901;4,99;2,1483;5,113;7,1158;8,553;7,403;6,940;3,1508;8,1603;1,712;6,1963;6,1116;8,1167;2,1065;8,342;8,858;8,570;7,1714;2,1380;5,79;5,1709;6,612;2,711;2,282;5,527;8,1172;7,1609;3,1401;2,866;5,1553;7,679;5,1295;8,802;3,1472;7,546;7,543;5,199;5,1316;5,1983;5,566;3,1247;5,1498;1,240;5,1580;8,1373;8,1688;3,1152;4,1799;5,1942;3,1802;7,1978;1,794;1,795;5,1282;7,1680;6,1853;4,1704;2,444;5,1752;6,642;1,1443;3,1346;3,1483;5,405;1,1207;7,1847;7,900;3,1438;2,1733;4,1228;5,445;2,463;4,531;1,946;5,771;1,38;6,1207;3,1796;4,891;1,1056;6,957;1,967;5,200;3,854;2,874;3,1153;8,1771;7,1402;3,797;3,1142;4,608;1,503;5,2000;6,926;6,1388;4,1868;3,1105;6,665;4,1557;2,1412;8,1180;1,1471;6,1465;6,1041;5,1057;3,1216;7,1544;1,1679;3,1485;2,285;5,1386;6,212;6,818;8,342;2,878;5,510;2,1504;2,1954;8,1401;7,599;6,1720;6,44;6,1422;3,554;1,101;6,1935;7,1620;6,606;3,1542;6,843;6,43;5,420;3,684;5,497;8,1604;4,446;3,727;2,1663;5,551;4,722;1,817;6,1123;6,1375;7,1423;1,1333;5,1834;3,969;4,942;8,962;8,1691;4,636;2,1210;1,539;7,1537;6,923;1,437;8,201;1,754;2,1039;7,404;7,509;2,982;2,1981;6,882;5,706;7,1206;4,296;1,1705;3,444;6,658;7,1743;4,1498;2,807;4,1686;4,954;5,994;6,607;6,948;5,501;6,330;2,449;6,1988;6,638;3,1666;6,171;1,1436;3,1274;8,937;2,859;6,831;4,591;3,1483;2,656;4,199;8,43;4,1761;7,234;1,271;4,1297;2,1302;6,817;8,1419;4,987;6,1523;6,1262;7,1077;5,31;7,960;1,758;4,1619;6,1529;4,1938;5,287;8,1399;4,1124;7,1650;1,1093;7,817;8,31;3,1072;1,1928;6,1010;4,1763;2,84;2,988;2,951;3,908;5,640;2,981;3,1464;4,144;8,1759;6,866;4,1840;3,14;7,580;8,1391;8,461;4,786;7,661;5,1605;6,1036;3,1090;1,190;5,130;1,750;7,1814;5,670;2,39;8,1847;4,92;8,1159;5,1769;6,1858;8,1035;8,41;2,572;2,1870;5,205;7,1802;7,1588;6,993;6,1605;2,217;3,719;5,316;8,375;7,1794;5,1007;1,1391;4,114;3,322;5,387;1,476;8,151;2,745;6,1163;5,458;5,1888;6,637;3,710;6,1609;5,1649;1,1902;7,452;8,1993;4,336;3,365;7,238;3,584;7,1477;7,307;4,1836;3,821;2,1135;5,1001;4,320;3,1572;1,1398;4,714;5,1733;4,133;4,86;2,630;2,1456;2,127;8,565;4,583;3,305;3,1866;4,1435;3,444;4,470;7,1928;2,149;8,1462;7,954;3,414;3,1490;2,815;1,287;6,547;4,1130;1,70;6,834;6,1998;7,323;4,216;1,131;6,495;4,130;2,386;2,203;2,1998;6,398;4,314;7,1979;6,1917;8,28;4,75;7,413;5,565;8,912;8,545;5,1054;1,1208;7,234;1,542;1,368;4,827;2,678;1,1484;5,183;1,1872;8,1384;1,1938;2,1236;1,1991;1,353;3,312;7,1834;1,1958;2,1302;2,435;7,1267;5,1669;3,827;8,1722;3,1651;2,348;5,1024;8,1065;2,486;7,1726;3,591;4,1534;3,1270;1,247;1,1709;1,1458;2,1101;8,1972;4,886;8,368;8,269;8,150;4,1228;1,1773;6,1436;5,8;6,1449;8,668;2,1040;3,646;1,1275;4,143;8,1195;1,1531;2,1680;4,399;3,388;7,1313;5,1785;4,949;8,1864;1,1429;7,15;4,720;1,1700;8,76;4,1481;2,1226;2,83;1,1959;4,358;7,954;5,1465;8,1288;5,1372;3,524;5,1775;6,327;6,339;8,168;6,1979;6,892;1,1997;3,1526;5,875;5,1992;3,252;2,664;4,34;4,936;3,1239;2,751;1,439;2,1984;8,1452;2,706;7,1404;1,1787;8,1524;1,633;4,1964;6,582;7,1050;5,1791;7,966;6,332;1,1205;4,307;2,741;8,1629;6,1694;5,1781;2,220;2,500;7,952;1,411;8,1021;1,1822;5,1276;6,1190;2,65;8,389;6,1969;2,1201;8,847;2,1270;6,1348;6,1968;8,629;4,350;8,824;4,1315;8,323;5,1663;8,1085;2,71;6,1954;4,291;3,1739;1,488;8,1175;7,320;3,1595;6,1136;3,1357;5,569;8,1118;1,1517;3,1377;5,471;3,1377;4,582;5,1292;8,731;8,1160;3,814;3,684;5,54;7,1776;6,1436;3,1503;8,454;4,1337;3,842;2,868;6,1367;7,1205;8,1204;1,1295;7,975;5,571;2,1753;4,474;5,1862;8,973;4,1104;4,1728;4,1331;8,916;3,1530;7,1913;2,405;5,1524;1,955;4,1564;5,1727;5,1557;2,1969;8,698;4,1324;5,1895;3,1067;2,742;7,330;3,1938;4,1789;1,635;4,539;7,1221;4,404;6,1242;8,1814;5,831;4,191;7,790;2,99;7,1077;6,372;8,1107;4,1972;3,165;4,184;7,37;1,1428;4,1485;3,1510;5,1467;4,682;7,415;3,987;3,999;4,1615;8,1399;8,422;2,355;7,1575;3,379;3,817;7,1200;8,1026;4,470;7,256;6,1144;1,695;6,138;3,1372;3,1240;8,587;3,912;6,25;5,1412;5,462;3,36;5,1337;6,1791;1,1014;5,280;7,114;4,34;3,1265;1,453;1,207;4,1258;6,337;3,1973;5,1254;6,343;6,988;8,1235;8,1750;5,1878;7,11;2,267;7,304;5,1144;8,778;8,1550;7,425;5,103;6,1926;1,703;5,124;3,1406;3,1382;1,1002;3,51;7,1061;4,633;4,633;6,880;7,444;3,342;6,807;2,65;7,914;5,1106;7,743;2,76;7,1409;7,391;8,1868;5,657;5,921;2,335;1,358;3,623;6,1882;4,1338;6,521;8,114;7,1025;1,1079;5,1342;7,278;8,1401;4,1754;8,793;1,1669;2,773;4,82;7,1424;6,1741;3,1725;7,797;3,1984;8,1173;5,1374;4,1068;7,1732;2,739;1,1653;1,465;6,369;7,924;4,731;2,829;8,1371;3,1398;3,201;6,581;7,1848;2,921;5,1226;6,707;2,1845;1,230;1,1964;4,869;6,354;8,890;4,99;5,1808;6,146;4,32;6,459;1,372;8,815;7,399;3,217;4,232;3,1313;5,1021;6,1278;5,566;8,1516;7,337;4,1055;7,640;5,1276;3,507;7,846;3,482;3,634;6,1114;1,1696;6,495;2,804;1,432;6,613;8,115;3,1788;5,855;7,1663;8,1243;2,1354;7,64;7,484;7,477;3,1409;6,939;3,1396;1,791;7,1657;1,1193;6,1298;5,568;2,731;2,159;4,191;2,1565;2,1829;3,1093;8,173;5,1604;7,1229;3,839;1,1404;6,482;6,1836;1,621;2,530;4,803;5,316;1,219;5,740;4,1126;2,1121;7,707;3,598;1,1038;2,100;5,402;3,1446;4,458;8,194;3,603;2,235;6,679;3,22;2,203;8,192;6,369;3,1032;2,1144;3,1849;4,1935;5,193;4,187;2,1496;3,385;1,1046;3,399;6,1253;3,1997;2,231;1,228;8,462;5,1832;3,1488;5,964;3,259;6,1310;8,409;2,883;1,1681;7,1788;8,1061;7,253;4,823;4,1277;7,1950;5,1920;1,71;1,1122;6,1580;2,1073;2,551;6,1710;6,1246;6,1278;1,1507;7,930;8,467;6,1814;8,1387;8,343;3,844;5,1801;1,1020;8,1705;6,923;7,1550;6,1293;3,715;1,1993;1,1045;3,399;5,1513;1,559;4,1378;1,713;1,732;4,1572;3,1470;1,995;4,1521;6,1323;3,1294;2,1676;5,240;5,219;5,336;3,1551;2,1183;6,1525;2,1934;4,1308;3,1896;8,447;2,610;3,864;7,1383;8,766;1,475;1,1593;3,1662;2,1595;8,194;1,1088;1,1860;4,597;4,24;4,1176;2,1238;6,399;5,801;6,1500;2,1223;7,1710;7,1801;7,1041;3,743;5,9;8,1770;1,539;2,1869;1,486;6,1423;1,1859;8,1945;6,258;5,151;6,1912;3,122;1,1691;2,610;3,826;7,381;8,4;6,360;3,626;1,1889;5,158;4,1623;2,1806;5,642;7,345;7,729;3,689;6,169;4,247;8,1747;8,586;7,1168;5,1531;7,249;3,367;1,711;8,1907;6,1129;1,1057;6,850;3,378;4,827;3,751;4,130;5,150;3,1282;6,130;4,1752;5,1003;8,371;5,1483;5,815;2,744;7,1575;5,1222;1,268;7,1686;1,16;3,1430;1,919;6,949;7,1019;1,79;4,1027;3,674;8,782;2,131;6,1751;3,97;2,650;6,797;1,1859;1,1743;3,1026;7,1837;8,894;7,832;2,1837;2,1827;4,126;4,323;2,1938;8,1931;8,1339;1,1830;1,1827;7,1771;6,748;6,1007;7,442;4,1568;7,966;1,794;5,1821;1,815;6,222;1,1252;1,797;7,326;4,680;1,564;5,920;7,1558;2,943;7,78;2,199;7,701;8,1507;4,1118;1,1228;6,1113;5,158;2,597;1,1724;6,238;1,977;6,318;1,1444;6,235;5,1851;2,1161;8,1896;4,1123;6,1084;7,174;3,247;6,1322;7,1871;1,1955;6,215;7,1047;4,168;4,1466;1,786;5,1098;5,625;1,1849;5,1934;0,0";

        int paginaFaultsFifo = executaFIFO(stringDeEntradas, tamVetMen); //Método para chamar o algoritmo FIFO
        System.out.println("FIFO Pagina Faults: " + paginaFaultsFifo);
        
        int paginaFaultsLRU = executaLRU(stringDeEntradas, tamVetMen); //Método para chamar o algoritmo LRU
        System.out.println("LRU Pagina Faults: " + paginaFaultsLRU);
        
        int paginaFaultsSecondChance = executaSecondChance(stringDeEntradas, tamVetMen); //Método para chamar o algoritmo Second Chance
        System.out.println("Second Chance Pagina Faults: " + paginaFaultsSecondChance);
    }

    
    // Método do algorítmo LRU
    public static int executaLRU(String referenceString, int memSize) {
        int paginaFaults = 0; // seta o número de faltas de página para 0
        List<Memoria> memory = new ArrayList<>(); // cria uma Lista para a memória

        String[] references = referenceString.split(";");
        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) {
                // Página 0 do processoo 0 significa fim da string, não conta como "pagina fault"
                continue;
            }

            Memoria entry = new Memoria(processo, pagina);
            boolean paginaFound = false;

            // Verificar se a página já está na memória
            for (Memoria Memoria : memory) {
                if (Memoria.processo == processo && Memoria.pagina == pagina) {
                    Memoria.menosUsada = 0;
                    paginaFound = true;
                } else {
                    Memoria.menosUsada++;
                }
            }

            // Se a página não foi encontrada, adicione-a à memória
            if (!paginaFound) {
                paginaFaults++;
                if (memory.size() >= memSize) {
                    // Encontrar a página menos recentemente usada (LRU)
                    Memoria lruPagina = Collections.max(memory, Comparator.comparingInt(e -> e.menosUsada));
                    memory.remove(lruPagina);
                }
                memory.add(entry);
            }
        }

        return paginaFaults;
    }
    
    
    // Método do algoritmo FIFO
    public static int executaFIFO(String referenceString, int memSize) { 
        int paginaFaults = 0; // seta o número de faltas de página para 0
        Memoria[] memory = new Memoria[memSize]; // cria um vetor de Memoria
        int currentIndex = 0; //contadores para fazer as substituições
        int older = 0; //contadores para fazer as substituições
        
        String[] references = referenceString.split(";"); // cria um vetor de Strings para separar as entradas da string de referência
        List<Memoria> referenceQueue = new ArrayList<>();

        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) { // verifica se é o final da string, onde a entrada é 0,0
                continue; // Fim da string de referência
            }

            Memoria newEntry = new Memoria(processo, pagina); // cria um novo objeto Memoria
            boolean paginaFound = false; // seta uma variável booleana para verificar se a página está na memória

            // Verifica se a página já está na memória
            for (Memoria entry : memory) {
                if (entry != null && entry.processo == processo && entry.pagina == pagina) {
                    paginaFound = true;
                    break;
                }
            }

	         // Se a página não estiver na memória
	            if (!paginaFound) {
	                while (true) {
	                	if (currentIndex < memSize) { // verifica se o índice é menor que o tamanho da memória
		                    if (memory[currentIndex] == null) { // verifica se encontrou algum objeto nulo da lista de Memoria
		                        memory[currentIndex] = newEntry;
		                        referenceQueue.add(newEntry);
		                        paginaFaults++;
		                        break;
		                    }
		                    currentIndex++; // Move o ponteiro para a próxima página
	                	}
	                	else { // Se o índice é maior ou igual ao tamanho da memória, vai utilizar o contador older para fazer a substituição do mais antigo
	                		paginaFaults++;
	                		if (older==memSize) {
	                			older = 0;
		                		removePaginaFromMemory(memory, older);
		                		addPaginaToMemory(memory, processo, pagina);
		                        referenceQueue.remove(memory[older]);
		                        referenceQueue.add(newEntry);
		                		older++;
	                		}
	                		else {
		                		removePaginaFromMemory(memory, older);
		                		addPaginaToMemory(memory, processo, pagina);
		                        referenceQueue.remove(memory[older]);
		                        referenceQueue.add(newEntry);
		                		older++;
	                		}
	                		break;
	                	}
	                }
	            }
	        }
	
	        return paginaFaults;
    }

    
    // Método do algoritmo Second Chance
    public static int executaSecondChance(String referenceString, int memSize) {
        int paginaFaults = 0;
        Memoria[] memory = new Memoria[memSize];
        int currentIndex = 0;

        String[] references = referenceString.split(";");
        List<Memoria> referenceQueue = new ArrayList<>();

        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) {
                continue; // Fim da string de referência
            }

            Memoria newEntry = new Memoria(processo, pagina);
            boolean paginaFound = false;

            // Verifica se a página já está na memória
            for (Memoria entry : memory) {
                if (entry != null && entry.processo == processo && entry.pagina == pagina) {
                    entry.referenceBit = true; // Define o bit de referência como true
                    paginaFound = true;
                    break;
                }
            }

            // Se a página não estiver na memória
            if (!paginaFound) {
                while (true) {
                    if (memory[currentIndex] == null || !memory[currentIndex].referenceBit) {
                        // Se o bit de referência for falso ou a entrada for nula, substitui a página
                        memory[currentIndex] = newEntry;
                        referenceQueue.add(newEntry);
                        paginaFaults++;
                        break;
                    } else {
                        memory[currentIndex].referenceBit = false; // Define o bit de referência como falso
                        referenceQueue.remove(memory[currentIndex]);
                        referenceQueue.add(memory[currentIndex]);
                    }
                    currentIndex = (currentIndex + 1) % memSize; // Move o ponteiro para a próxima página
                }
            }
        }

        return paginaFaults;
    }

    // Métodos auxiliares para os métodos dos algoritmos
    //Método para encontrar o indice do vetor de memória do processoo e página correspondente
    public static int findMemoryIndex(Memoria[] memory, int processo, int pagina) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] != null && memory[i].processo == processo && memory[i].pagina == pagina) {
                return i;
            }
        }
        return -1;
    }

    //Método para adicionar uma página na memória
    public static void addPaginaToMemory(Memoria[] memory, int processo, int pagina) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == null) {
                memory[i] = new Memoria(processo, pagina);
                return;
            }
        }
    }

    // Método para remover uma página da memória
    public static void removePaginaFromMemory(Memoria[] memory, int index) {
        memory[index] = null;
    }
}