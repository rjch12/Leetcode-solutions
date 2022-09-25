import java.util.*;

class palindromePairs_336_2 {
    public static void main(String[] args) {
        palindromePairs_336_2 pp = new palindromePairs_336_2();
        /*
         * List<List<Integer>> res = pp.palindromePairs(new String[] { "ceihdihhjf",
         * "cgadb", "cfhbaf", "fcfbejidbddced",
         * "cihhbiajagbh", "cabhfhch", "gfhdcdhejigcc", "g", "cbhbcgch",
         * "difbbdhdhaeciib", "effecbhbhdf",
         * "fgcafcd", "efh", "ijjajdcaj", "aiaihadf", "ef", "ccceif", "jfacd",
         * "fgcgfhfadhhgbbgfej", "ebibdhabj",
         * "haegbddgahihieic", "hhajiidj", "jajhff", "fffhhddfee", "ea", "hd",
         * "hbhdagbgjb", "afhajbccijfadicebd",
         * "bcai", "ijfdhibgejfjbaacifa", "fbgafffffigbe", "gdghjddjbja",
         * "cefjaebbgdgdih", "cehjfb", "bhidfccig",
         * "hhd", "ccdhbdede", "jjeae", "hbaaghcccfcbeedagfg", "dhjbb", "cfbjifggehh",
         * "hjfcdgbijjcaj", "djcjh",
         * "eajdjhihjjggicceadd", "jdifcieabhbd", "bfhdf", "egafffffhgi", "jdaceccg",
         * "ichfjd", "badidae",
         * "igccchcdbigbhffcb", "gffcecgajiieahcdhebi", "eheeeciidfg", "ga", "haeifij",
         * "hbgjgbaig",
         * "jiehhdhjcaiagbfhgeah", "fedig", "bbgigihc", "eicjffbjfcgch", "j", "dhb",
         * "jghighcdggdhieeeb",
         * "eahiabfeic", "eecdjg", "fdcf", "gfggh", "hjaifeeejahcb", "iiibfggebecc",
         * "iiaaidecgcajjjbhfi",
         * "hcjbicbdch", "gaicbddaf", "iijhf", "giaejieefchf", "dhffaheghcafch",
         * "gjabdhhefdiaehjhjj", "fhffbad",
         * "jdifdhfhfdcb", "gfihcjacji", "jefbejjgeahbjhijgg", "dacbaiaibgjbfdcigie",
         * "idjgbfgjieidg",
         * "eejhghgcjhefgihgde", "ecfdgeehdi", "bbddhiiahdicbhdhjcbe", "adfehde",
         * "bfg", "fdhdcjagbbgdiij", "jfijbbaghjjfgjaahf", "aefdfigadfbghhbdjb",
         * "fchhgfjdfciehjici", "fiiaic",
         * "a", "gafjhejdcaghibjee", "bggeaheggcfhe", "bcdcijdcagbhfga", "ee",
         * "jijbidb", "dfhjeggbajcejddig",
         * "hfcejgdfejdgdcghfadd", "cffcegcedfdi", "cigigbif", "cfacci",
         * "eeefghfhgigajb", "jhhfhii", "cbfj",
         * "ffc", "cbfhbchigghiaeighcff", "idiibcefghgeii", "ghhgfcibj", "bj",
         * "bahbcbig", "difcajjfedbideggibca",
         * "hhbchfhe", "eejefejfchaccgfcec", "dceaag", "hfebcbf", "ffebfajachfid",
         * "fidjceeijiibe", "gdcf", "hja",
         * "hbacbbffbiafbaddgffi", "ifeicggcgfddihjgcghj", "gjchif",
         * "dbjgccigejjbafdedefg", "gicjjeacejeaebdj",
         * "aghcfeibidebhbebbaa", "id", "fhcdbb", "bhahe", "ch", "hjhii",
         * "cccgehajgcaijfggahca", "adiegcibbhjad",
         * "djcbbibidhcghj", "djhdbgechjcgif", "eah", "hgcf", "hdb", "bdhcdgbccaiebe",
         * "daiffbeg",
         * "hbfifcabjjcbbbgfcc", "geghddihhjdjijhdc", "dcba", "ddcaggiefii", "hhfgbf",
         * "fjhdedgeiajah",
         * "cfceffhjbjdee", "iddhdaae", "ageecde", "fdf", "dahc", "chafidaaeh", "ic",
         * "fdfifibjja", "dhbhjjbef",
         * "jihgdjgegaj", "dceeabhdicjjcbdfae", "ec", "dacfacbifdaidb", "hdga", "ji",
         * "didjjghgfecidfjjhdeb", "cg",
         * "fa", "bafdjeifbb", "igeebdabeijbhdbj", "bfchdfecbch", "adegbgi", "gicjia",
         * "ggbaegcabaigiaed", "dh",
         * "d", "bigadficje", "hca", "hhjecafijiebffgdji", "aeeeefficab", "addgehffb",
         * "fci", "bghgfgcage",
         * "cafidhegehcjdbagic", "egehiibbicd", "dhjajggj", "efbbbhifafgddidhc",
         * "bhhaffghebjcdfaagc",
         * "fdfahadidhbeachegg", "cbihi", "gfdhh", "gddcidjafg", "bhchddaggifchceedf",
         * "hcceecbeiaebbaiefi",
         * "effebhafgjcadbhheah", "agadihecd", "ebcadbjjfdddebfbgg", "jjbcaceabicjcb",
         * "ebdaghghic", "bhajb",
         * "jfifhgbhj", "abdcfbjcdcbfig", "agcga", "jedcfihdbbfgefhjbeeg",
         * "ghechefddiac", "agjhfeifhggecfeeje",
         * "fifjdhddchgee", "ejidcdjjbebj", "ccehcbaai", "bifadabfeef",
         * "bcjbhgeeiihgggj", "idhjhgdfjhjihhjj",
         * "agdbehhjdfdjab", "bhgaddi", "difjcbfdhi", "affchbcjgb", "cidijjic",
         * "ifbgjjbga", "gacgaigejjfejcbc",
         * "babegbfabe", "dgihbbhbfjigccidjaig", "hhfegcbfdaa", "iccda",
         * "gbfjgfjahicegfhgffj", "fchdg",
         * "cfhdciiiddchhchb", "diafafchccjhhchcfbc", "befcaifhcebjdeghc",
         * "ihdbccgjjhe", "iiigdec", "eafaidf",
         * "chfee", "bjjjabbibggad", "jfjeb", "dfbfiheceieja", "hjfcfbhdhdgeeaee",
         * "fafbb", "acijhacdhccbadfehbfb",
         * "bedfehgeidadgechddgd", "dfbcbeifabfefigfi", "iafbdc", "acibc",
         * "bgehddbcecb", "aaigbdaaefhcfhbfdfhh",
         * "ffaibdaghe", "gchhbcficdeifidebcg", "ccidaeeggh", "aidcacdacaahhhbhfci",
         * "dd", "fafehbgicjehbaj",
         * "eggdieibgaidhjjhfdj", "jieeagfgbecfg", "igjdihhcehiacheegaa", "gejijggfjih",
         * "cjfbejbhfba", "ifdb",
         * "ehhhgh", "eaaabfge", "agd", "edffcjfjgbbjbcac", "bafbhhecghf", "da",
         * "begadd", "fheggfhfcjhb", "dhbb",
         * "efahf", "eddcdagiejjibejc", "cbjibibdhieii", "edajcghgebcgfga", "hghaeggea",
         * "bjecdbifg",
         * "afgajchhdfcbjcdajb", "hdhadcdcabdbdb", "dahgjdaeaddhhcafai", "bebdg",
         * "eichhfagcahbiadh",
         * "gfahfcaiehiijigc", "gibhcg", "hef", "jaiibaif", "agecc", "fajhbgfgh",
         * "fddacfcf",
         * "cgifaigbdadcefabfdia", "gjdghcibhiaac", "ae", "hagiee", "ajadhgccgb",
         * "iciaffifdicbd", "hbgici",
         * "aejcbhdhaicdafebdad", "gefjbcjdhg", "eh", "ibeaa", "ffihdjachggficfehbb",
         * "jaahf", "dgiaaacjcdhbeja",
         * "hgcajbi", "jgjccbeigc", "hjehjihi", "bcjigii", "aih", "ggdjhfhaiccfieb",
         * "acgifejfjgb",
         * "ghfefbaijfdifjhjh", "dbeeaeb", "cidabj", "ichjahdghf", "hcejiaccggebj",
         * "djaaaecifecjegj",
         * "icgcbacebjcaaed", "fga", "djdahgghbafecjhgggha", "hbhecfb", "bfjaacif",
         * "eeidheg", "b", "ifjicahcgaba",
         * "cgagijiabddfjfgbj", "fjgjeabgchheeedebbfd", "edabdbdg", "e", "hhabcjfdajcj",
         * "cdihgdjeadcfcgfg",
         * "fidgjhccihdaiahfjad", "babbfjdeg", "igcbaid", "affgaid", "jfe", "iideaa",
         * "fhhee",
         * "eecbefbajihegecjecai", "bebgfechifdceihfj", "gdcidfgh", "daibbdeafd",
         * "aciaeehcag", "iffedcbhahbejchc",
         * "gejbbijhfia", "ejhdfajbechehjddd", "afdcabfbbchbicfaeea", "bdgbjaabafh",
         * "iahfjeg", "haciacehiefhba",
         * "acdegchdb", "ehbddfjdfjhahbggeje", "bcaejdi", "abhce", "gdiicf",
         * "ebfgfhbegcbeecdh", "efibajhieedic",
         * "bggfagageeijbcbhg", "hgdgabbijadgecchee", "ehgfihcijfefeacca",
         * "ffbfhgaebbbihbibgcf", "cebj",
         * "dachdifb", "cedbfgfid", "fedbhhhdbhciifjghdc", "afjghdbbefciba",
         * "febfefhiiaiegggic",
         * "egjchhehfaeacejg", "jjagghagcfaiacadei", "fcjigfbf", "ehffdibghhcg",
         * "ibaeadhha", "bachbfjjefbgab",
         * "bgaghbcdgdafaeaf", "gggcegbhdibchggjhej", "hfh", "ihg", "gac", "bgbibicf",
         * "jhbceajacegabgc",
         * "gdijbejgfghfhjai", "afijddcdjdehgji", "hig", "hiceebeccefieggi",
         * "ibejeejeijiidjbc", "jebdbbhfifc",
         * "cahbajaaahf", "ifdfeeeabec", "cagfcjachhfffh", "gfce", "ejejfdgfc",
         * "dajjgjdafddf", "ifcgechcc",
         * "ciiffheiffefbaadf", "eijaiijccgfeb", "bjbgaeijfdfcjhad", "hjafeeeajc", "gi",
         * "ihihj", "i",
         * "hhjebbiicgfjbbciecf", "eahhbie", "gej", "fb", "ejfaagdefgh", "gcaddjejd",
         * "aiedige", "fdjhffdhbfdf",
         * "idcdfebiffi", "bffbbbch", "bajbcdcea", "hajfgehfe", "hgcidecedbddgae",
         * "hchijjhdbcbjdbfja",
         * "gjaejbdfgdcjdab", "achhcaaei", "ghbbe", "hfidfjefbiaif", "hhfbhgeedhgc",
         * "accajgcggdfa", "ecbdcj",
         * "fgbf", "gafdhbcfhehefffhj", "hhg", "gjcfchfeafcbgb", "fbbdijjcc",
         * "fgacffcidh", "fdgj", "fbgadfheabdf",
         * "acfeebediijjdghgj", "eijjgibdecfj", "dbbj", "daicjhchcchfcdh",
         * "jfjgdjfgcgi", "baba", "fedhibaifad",
         * "igehejicdgii", "bdjhgch", "eibhibajfccfiffh", "faj", "jdbhdihgiggfjfd",
         * "iieaajejdi", "ehdgfc",
         * "gjcdgjjahhbeaafbcgg", "hbecgccff", "fbjeghfhgh", "ddjbd", "jjcffdij",
         * "jchhbf", "ebafiggdhdibbdi",
         * "ib", "jacigfjhbffjbd", "afjigefihcabej", "iaiccbhdgcahijhada",
         * "cihifhacdgjfacfej", "iffigaaabfg",
         * "ccibccf", "aajhjdfjhjdihdhbg", "h", "agcfieja", "fjdgjiiabjdjdcfcdfb",
         * "jdjf", "bdabcegcbdbbafce",
         * "jedifaejjggffef", "cccah", "heha", "egfehaeie", "ichffja", "iachcedbg",
         * "ffiiibbec", "adigide",
         * "jhcbchieabgajfcdh", "cf", "acdhgjiidjaiafchcfgi", "hfci", "dfaggfjehc",
         * "hgadjcfhhjjeiacd",
         * "gebjfajgaha", "iajeiafc", "dhe", "aebeefdhfhhj", "idja", "eajh", "hbadebdj",
         * "fcdceidehgjedhfh",
         * "jgghhaafi", "ihigjc", "jfegcjihfbjbgi", "daebbihjiccd", "bjd",
         * "acgchegfhedccaifc",
         * "bgcafedigicbffbjea", "ggeajcadafdhgfecg", "ccbcgecgcghcff", "bdjeigghah",
         * "caehjfbebad", "ibjjhahgf",
         * "ajbdhaabiebbjd", "eccgifcccdacjcbce", "jdbbhhb", "fjaecagdgghi",
         * "eidciccjifighhffjecd",
         * "adcfbdecaehbhf", "deaiig", "eiajggaabjhgdgbdj", "ddecjdc", "ccibdeijbebfbe",
         * "igdhgdbhjhajaibiee",
         * "cfecfchgdch", "ahaabdgibchcijceicd", "ecjgfciahee", "gciijjb", "iajg",
         * "fgefbdb", "jbdebf", "cbb",
         * "ajaidd", "bfghefdiecdea", "gbddjj", "chdb", "fdfi", "acdif", "jdbhjhe",
         * "dbhcajicgdeicbggcgb",
         * "dcbfbafgbh", "jbcdhgdbdjfd", "eehehecgdgfejgjhifb", "iaahaij",
         * "ffhjaibjihdgefg", "eecedhdjehf",
         * "figgfhiia", "ah", "ebigjefcfegadghj", "ededgbedaegeiffifjd", "hdcciijhiid",
         * "fdehgbcaaddedbcebbgi",
         * "caciajjbege", "aeecaeibaghhjggbadjg", "achjai", "geghfgicfhihhciggaj",
         * "feghgghcggc", "cffjhbgfjb",
         * "adjbieig", "aejjjg", "bgghfgheechcgjiidf", "ihbffed", "ehfcdgffbicghhh",
         * "cfhefdidbjihhfcijhei",
         * "igficbj", "abfeeghjc", "hjid", "bficcdeghcaed", "hia", "jgaabaajiggcgccjgj",
         * "ajiccddejgahdiddbii",
         * "djbeceahejhffcg", "deejjfbgdadbajjdg", "djijcjgdch", "aihje",
         * "ajbdheebaadhjjidhjb", "fcbgdjdgjfbd",
         * "dg", "iag", "cdceahbcijaeicfcjagg", "bafdbdefhhbdg", "fhdiijigcghihhjiah",
         * "fefhaedaajg",
         * "gibdbbfhfcjajif", "jhigdid", "bjhbg", "jejg", "fcbbbhdchc",
         * "cccdfhbijjdfcacfdegg", "fjbdhccdcfiij",
         * "gfffibjjbjdbf", "giccdjchhebfhjiddba", "jhg", "eidd", "hicgfhfb",
         * "fabafcbfaaefgabef", "gajegda",
         * "egjgffedcijd", "fadafc", "hjefbhjidichdejbibad", "fjaiifgbjj", "iaheejde",
         * "becfbgibhfadbig", "c",
         * "habiibajcfaiihgg", "bchfghdab", "caj", "ebgjgicijijigcgjjb",
         * "faggcaceaebghfc", "aeeefajcijjffdej",
         * "ehcdjaiii", "gdcejeed", "bifjggajiehgggd", "egacdbhgehjj", "cddjiddj",
         * "idgagcejdijejhdhg",
         * "jhfahhcagdjechh", "bbbeidjehhajj", "dhijaegfiha", "hedgeifaaefeehbigff",
         * "jgaifh",
         * "ibiacgeahieicdchfhd", "hfedajjg", "iccgggbecbj", "effgbhgibaefga",
         * "jfadghhgfhgdjddecfd", "dcdhg",
         * "abejdahiadbcihcf", "dagjeg", "hagedebfebjbejac", "hadbjeeaghbjgbhhajh",
         * "jcagbjdbfe", "caf", "jbdcc",
         * "cbbffgb", "acdijjcceffgcib", "ddaabbdjigibeicfgefc", "agjdhdedfechajjjf",
         * "idgeaiachii",
         * "aghfhgajgebgdcifgbjd", "fha", "gaadcgjaci", "bh", "ifgedi",
         * "gjaiebjiafbggbajf", "adddachee",
         * "iaijfbfhfbjejbf", "ifajegfbii", "jhiabchddifjjg", "afafdfjifgc",
         * "cebchcaaeaecbh", "idigjejighhb",
         * "jfedejbjdbae", "ccbjbdh", "ibgebaeaigejcbgdjii", "bi",
         * "ijgbfcecfgdbbaeeihj", "aaiccbicde",
         * "cjieffjaifbe", "hahabfddbe", "caff", "eheichbjgejhgcgeecca", "dafi",
         * "fjbiejeaabcddaa",
         * "bcceciadcejghdjffcc", "dghgfeeccidcbie", "gijhcg", "heaabebabebgdgdgb",
         * "abfdfdcgffihjfdef",
         * "abibbhceghjjejcaae", "icdfdf", "ihgfgceafggge", "hadcecibdieag", "agjabf",
         * "abaihg", "jbcbb",
         * "icdfdigfj", "cefa", "eaiaagghbdhbjc", "gcgcijdbaiibfhgheig",
         * "bhijfjejficea", "cgbdhhbdhhicbb",
         * "bdjaad", "dchajdgbdd", "jddcbieficfe", "ihahhffiafjecab", "ifiefejhdgae",
         * "dfdjdebbdfhj",
         * "iijgijbfigdghb", "abbi", "hfahaeaefededhdg", "jbgifbfefaidcjeeic",
         * "fagfdgjgebaedhd", "bhdf", "jbcgfh",
         * "jdhhdfeabiafjc", "fchgejeibb", "jcjccah", "bigb", "digijeacaafjbjaidi",
         * "hfabeicbffbhbiahcbed",
         * "chddfde", "efegbhficfcfh", "ihdgg", "hcgdejbfbjjcb", "ahcag", "hjhffjihjg",
         * "bcbaidfgafecc",
         * "afafehajchfbhi", "idbejgihdeia", "daajgjahbfeij", "jjdjicidiiiaefbibafc",
         * "iifhgdhcchaae", "gahd",
         * "dgab", "ccbcaebcigegighceica", "ehgbjdgd", "ajc", "fgihdbhfebehgicdbhhc",
         * "eicfeajifbhif", "igdacjf",
         * "giiaaijjjbccfbjfeigj", "bedffcbjajieig", "hfdichgjgcabfge", "djghhef",
         * "jgaicjdajjdjahjiab",
         * "gacfgiadjeecgbgghhc", "idhbdjbffefgbagjhf", "gajadecgadje", "gfbegidc",
         * "ihigjcdiff",
         * "jhgigjahjaifbce", "cjghafff", "jihcf", "hheeeeddbajafff", "dgcdcfcha",
         * "egbdcbg", "iccj", "adbfaiddch",
         * "iahacdbjgdgggigiejh", "bjiedeadbjfcjfbce",
         * "bifbiiehfjifbjigi", "iadcijefg", "gecjhcbcjff", "efggchbcidaeheged",
         * "eeacfdca", "hegebejeigfjaf",
         * "iadeif",
         * "bhieceaghjihfigii", "bihdefdcfbjjfbgfece", "gbg", "dggbeabgfddfjdhabb",
         * "acdbje", "caecf", "cijaejfhh",
         * "beeadha",
         * "hgfajfciafbej", "fheigichbajbfj", "becehfgddhbceiicg", "dhecjha", "cajaib",
         * "ecidghihidffhaaacf",
         * "fieahbfgbbijadjghjf", "icjgdcfj", "ajabeacfiahbhbbgicfj", "hj",
         * "abghhcafebjcjigggidj",
         * "gadbifacejjaag", "ifdf", "icffjchfbgijebij", "igaabaaefdhb", "bhbiachcb",
         * "heddffihdedeffc", "gffjg",
         * "fhae", "adjhbfeeafgbfccbgj", "defi",
         * "idecjibbdfiafhf", "hagcicfac", "idhdd", "haaiadcgdaajieihjg", "dhjhcjcijj",
         * "aefgecehagfeehhhhe",
         * "decficaijjaej",
         * "ecebficebafgid", "dfhiaafd", "edadgaibfdfj", "bifighfgd", "ajiijdbidjjgjca",
         * "effdgje",
         * "iajcjaeegafefgfb", "jgiaddd", "aibh", "chjejdci", "biggbjhageichidibhi",
         * "cb", "fddfgciebfha",
         * "hgccbdabffhgg", "jcgibeigcf", "gffehegbjfcigbf", "jfaaebifddgibcd",
         * "ihcagbggabbf", "bifgdhcg",
         * "gijfeaiiaicjfhjgjg", "hbgfhgg", "dedfcjbejghfdgabbihg", "dgficcaeieghaffef",
         * "fefddddfddhgifhfbgjf",
         * "dheicfcdifbjabgeg", "cic", "jhajfb", "bbhfhgaibde", "cedaeiggjgdcfa",
         * "jjjbgafgi", "dfgccei", "ffdgg",
         * "jfhhhjfhhdgheahhfgg", "abjcgc", "jihjg", "dehjjfiijhc", "ehjhbfgijf",
         * "fejgjgchdhidic", "fgdeab",
         * "aje", "bgiaijiidjfahifj", "aaacjachejjabadbfd" });
         */

        // List<List<Integer>> res = pp.palindromePairs(new String[] { "a", "" });
        List<List<Integer>> res = pp.palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" });
        // List<List<Integer>> res = pp.palindromePairs(new String[] { "bat", "tab", "cat" });
        for (List<Integer> pair : res) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> hm = new HashMap<>();
        Set<Integer> hs = new HashSet<>();

        if (words.length == 1)
            return res;

        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], i);
            hs.add(words[i].length());
        }

        if (hm.containsKey("")) {
            for (String word : words) {
                if (isPalindrome(word)) {
                    if (hm.get(word) == hm.get(""))
                        continue;
                    res.add(Arrays.asList(hm.get(word), hm.get("")));
                    res.add(Arrays.asList(hm.get(""), hm.get(word)));
                }
            }
        }

        for (String word : words) {
            String rev = getRev(word);
            if (hm.containsKey(rev)) {
                if (hm.get(word) == hm.get(rev))
                    continue;
                res.add(Arrays.asList(hm.get(word), hm.get(rev)));
            }
        }

        // s_left + s_right + s2 =
        for (String word : words) {

            for (int i = 1; i < word.length(); i++) {
                String rev = getRev(word.substring(i));
                String revleft = getRev(word.substring(0, i));
                
                if (hm.containsKey(rev) && isPalindrome(word.substring(0, i))) {
                    if (hm.get(rev) == hm.get(word))
                        continue;
                    else {
                        res.add(Arrays.asList(hm.get(word), hm.get(rev)));
                    }
                }
                if (hm.containsKey(revleft) && isPalindrome(word.substring(i))) {
                    if (hm.get(rev) == hm.get(word))
                        continue;
                    else {
                        res.add(Arrays.asList(hm.get(word), hm.get(rev)));
                    }
                }
            }
        }

        return res;
    }

    public String getRev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
