import store.Store;

public class Main {
    public static void main(String[] args) {
        Operational store=new Operational();
        store.run();

//        Goods[] someGoods = new Goods[21];
//        someGoods[0] = new SmartPhone(74007627, "Samsung Galaxy M30s 4/64GB Gradation Blue", 15,
//                "Экран (6.4\", Super AMOLED, 2340х1080) / Samsung Exynos 9611 (4 x 2.3 ГГц + 4 x 1.7 ГГц) / " +
//                        "тройная основная камера: 48 Мп + 8 Мп + 5 Мп, фронтальная 16 Мп / RAM 4 ГБ / 64 ГБ встроенной " +
//                        "памяти + microSD (до 512 ГБ) / 3G / LTE / GPS / ГЛОНАСС / BDS / Galileo / поддержка 2х SIM-карт " +
//                        "(Nano-SIM) / Android 9.0 (Pie) / 6000 мА*ч", 7299, "Android 9.0 (Pie)",
//                4, "DDR5", 8, 2.3, 6.4, 18, 12);
//        someGoods[1] = new SmartPhone(113475716, "Motorola One Vision 4/128GB Bronze", 31,
//                "Экран (6.3\", IPS, 2520x1080)/ Samsung Exynos 9609 (2.2 ГГц)/ двойная основная " +
//                        "камера: 48 Мп + 5 Мп, фронтальная камера: 25 Мп/ RAM 4 ГБ/ 128 ГБ встроенной памяти + " +
//                        "microSD (до 1 ТБ)/ 3G/ LTE/ GPS/ поддержка 2х SIM-карт (Nano-SIM)/ Android 9.0 (Pie)/ " +
//                        "3500 мА*ч", 7999, "Android 9.0 (Pie)", 4, "DDR5",
//                8, 2.2, 6.3, 15, 12);
//        someGoods[2] = new SmartPhone(125110793, "Xiaomi Mi 9 Lite 6/128GB Grey", 22,
//                "Экран (6.39\", AMOLED, 2340x1080)/ Qualcomm Snapdragon 710 (2.2 ГГц)/ тройная " +
//                        "основная камера: 48 Мп + 8 Мп + 2 Мп, фронтальная камера: 32 Мп/ RAM 6 ГБ/ 128 ГБ " +
//                        "встроенной памяти + microSD (до 256 ГБ)/ 3G/ LTE/ GPS/ поддержка 2х SIM-карт (Nano-SIM)" +
//                        "/ Android 9.0 (Pie) / 4030 мА*ч", 8499, "Android 9.0 (Pie)",
//                6, "DDR5", 8, 2.2, 6.39, 17, 12);
//        someGoods[3] = new Computer(40612856,"IT-Blok Прогрессивный i9 7980XE B", 19,"ntel " +
//                "Core i9-7980XE — топовый процессор для настольной платформы Intel LGA 2066.\n" +
//                "Данный процессор имеет 18 ядер, которые работают на штатной тактовой частоте 2.6 ГГц, и 4.2 ГГц в " +
//                "режиме Turbo Boost. Из особенностей стоит выделить 4-х кaнaльный контроллер пaмяти DDR4 и " +
//                "рaзблокировaнный множитель.",157486,128,"DDR4-3000 MHz",18,
//                4.2,3584,1582,11,"DDR5",24);
//        someGoods[4] = new Computer(116294137,"ARTLINE Gaming X48 v09",41,"AMD Ryzen 5 1600 (3.2 - 3.6 ГГц) / RAM 16 ГБ " +
//                "/ HDD 1 ТБ + SSD 240 ГБ / AMD Radeon RX 580, 8 ГБ / без ОД / LAN / без ОС",18360,16,
//                "DDR4-2666 МГц",6,3.6,36,1257,
//                8,"DDR5",38);
//        someGoods[5] = new Computer(104096478,"Lenovo IdeaCentre A340-22IGM",32,"Экран 21.5\" (1920x1080) Full HD / Intel " +
//            "Pentium Silver J5005 (1.5 - 2.8 ГГц) / RAM 4 ГБ / SSD 128 ГБ / Intel UHD Graphics 605 / без ОД / LAN / " +
//            "Wi-Fi / Bluetooth / кардридер / веб-камера / DOS / 5.8 кг / черный / клавиатура + мышь",11355,
//                4,"DDR4-2666 МГц",4,2.8,18,
//                750,200,"Intel UHD Graphics 605",12);
//        someGoods[6] = new Vegetable(18815916,"Каштаны органические Markal 230 г",132,"Очищенные плоды каштана, " +
//                "запеченны. Отличаются нежной структурой и сладковатым, ореховым вкусом.\n" +
//                "Съедобные каштаны не только вкусные, но и очень полезные, в их состав входит до 3% минеральных " +
//                "веществ, 2,5-3,5% клетчатки, витамины А, С и группы В.\nСостав: 100% очищенные каштаны органического " +
//                "происхождения",342,"Сухие фрукты","12/5/2018",15,"1098 дней");
//        someGoods[7] = new Vegetable(25103553,"Папайа сушеная Winway палочки 100 г",321,"В сушеной папайе много " +
//                "витаминов. В этом продукте представлена почти вся витаминная цепочка от А до Е (особенно много " +
//                "аскорбиновой кислоты и витаминов группы В). Из микроэлементов можно выделить кальций, железо, цинк, " +
//                "а также глюкозу, фруктозу, полезные минеральные вещества и растительные ферменты.",40,"Сухие фрукты",
//                "30/7/2019",20,"12 месяцев");
//        someGoods[8] = new Vegetable(10489161,"Манго сушеный Seeberger ломтики 100 г",431,"Ярко-оранжевые ломтики " +
//                "сушеного манго Seeberger одинаковой толщины, сочные, как спелый фрукт, и сладкие как мед. Равномерно " +
//                "просушенные под тропическим солнцем, дольки манго не содержат добавок сахара, поэтому сохраняют свой " +
//                "естественный букет вкусов из яблочной кислинки, аромата апельсина, сока персика и даже легкого привкуса " +
//                "дыни.\nСостав: Манго ломтики (примерно 1.2 кг свежего манго), картофельный крахмал, диоксид серы",
//                182,"Сухие фрукты","3/2/2019",20,"9 месяцев");
//        someGoods[9] = new Sweets(11986199,"Маршмеллоу Millennium Барбекю Гриль 225 г",436,
//                "Бельгийский маршмеллоу Millennium Барбекю Гриль.",40,"26/7/2019",
//                25,"425 дней");
//        someGoods[10] = new Sweets(12362905,"Упаковка Яиц Kinder SpongeBob 20 г х 36 шт",58,"Упаковка с 36 яйцами " +
//                "Kinder Сюрприз из молочного шоколада с молочным слоем.\nВнутри каждого яйца — оригинальная игрушка " +
//                "из серии SpongeBob. Собирайте яркую коллекцию вместе с Вашими малышами и Kinder.\nKinder — детский " +
//                "бренд итальянской компании Ferrero, который знают и любят дети во всем мире уже 50 лет.",1220,
//                "4/6/2019",15,"365 дней");
//        someGoods[11] = new Sweets(98094604,"Упаковка карамели-шипучки Chupa Chups B-Pop Тропические фрукты 15 г x 45 шт",
//                231,"Chupa Chups B-Pop — вкус тропических фруктов и шипучка сверху конфеты. Искрит тропически! Шипучая " +
//                "штучка!",565,"21/5/2019",25,"730 дней");
//        someGoods[12] = new DrinkWater(9145560,"Упаковка минеральной лечебно-столовой сильногазированной воды " +
//                "Borjomi 0.5 л х 12 бутылок",527,"Минеральная лечебно-столовая сильногазированная " +
//                "вода Borjomi - минеральная вода вулканического происхождения. Насыщенная природным углекислым газом, " +
//                "она способна подниматься на поверхность без помощи каких-либо насосов с глубины 8-10 км теплым потоком " +
//                "(38–41°С). Проходя через породы Кавказских гор, Borjomi обогащается композицией из 60 различных " +
//                "минералов.",280);
//        someGoods[13] = new DrinkWater(9145217,"Упаковка минеральной природной столовой негазированной воды " +
//                "Моршинська 0.5 л х 12 бутылок", 761,"Моршинские источники – одни из немногих в мире " +
//                "месторождений чистой природной воды. Рожденная в Карпатах и защищенная заповедными лесами, «Моршинская»" +
//                " имеет сбалансированный состав и наилучшим образом подходит для ежедневного употребления, так как " +
//                "отличается низким уровнем минерализации. «Моршинскую» не поддают дополнительной обработке, так что она " +
//                "сохраняет состав и свойства, задуманные природой. Благодаря уникальному комплексу микроэлементов " +
//                "моршинских источников эта вода изо дня в день помогает организму работать правильно. Как результат – " +
//                "вы в прекрасной форме.",109);
//        someGoods[14] = new DrinkWater(6802809,"Упаковка минеральной негазированной воды Evian 0.33 л х 6 " +
//                "бутылок",983,"Evian – это cамая известная в мире минеральная вода. Она добывается " +
//                "на северном склоне французских Альп, в районе далеком от городов и промышленного производства.",
//                199);
//        someGoods[15] = new SweetWater(17569996,"Упаковка безалкогольного напитка Pepsi Max 1 л х 12 бутылок",
//                543,"Упаковка безалкогольного напитка Pepsi Max 1 л х 12 бутылок",180,
//                "5/5/2019",15,"6 месяцев");
//        someGoods[16] = new SweetWater(7118224,"Упаковка безалкогольного напитка Coca-Cola 2 л х 6 бутылок",
//                641,"Coca-Cola была создана в Атланте, штат Джорджия, доктором Джоном С. Пембертоном в далеком 1886 " +
//                "году путем смешивания сиропа и воды. Регулярное производство Coca-Cola началось в 1887 году, а торговую " +
//                "марку было зарегистрировано в 1893. С тех пор Кока-Кола — это бренд №1 в мире.",150,
//                "7/9/2019",15,"6 месяцев");
//        someGoods[17] = new SweetWater(9886237,"Упаковка холодного кофе Капучино Landessa Ice Coffee Cappuccino 0.23 л " +
//                "х 12 банок",92,"Холодный кофе Landessa Ice Coffee — Cappuccino в картонной эко-упаковке. Изысканный " +
//                "вкус натурального кофе из 100% арабики с добавлением отборного альпийского молока и натурального " +
//                "ароматизатора ванили подарят вам настоящее удовольствие.",542,"6/8/2019",
//                15,"365 суток");
//        someGoods[18] = new Wear(33168751,"Куртка Colin’s CL1032686NAV L",27,"Компания " +
//                "Colin's основана в 1983 году в городе Стамбул. Ее основателем стал начинающий предприниматель Нуреттин " +
//                "Эроглу (Nurettin Eroglu), который вместе с четырьмя братьями открыл небольшое семейное предприятие под" +
//                " названием Eroglu. Регулярное обновление коллекций, содержащих порядка 2000 моделей, привлекает " +
//                "внимание самых заядлых модников и модниц. Сейчас Colin's один из самых узнаваемых молодежных брендов " +
//                "в мире. Кто выбирает Colin's — тот выбирает высокий уровень качества, стиль и комфорт от производителя.",
//                1599,1983,"COLIN`S",8000,25);
//        someGoods[19] = new Wear(67773586,"Кроссовки для бега ASICS Gel-Cumulus 20 1011A008-001 42.5 (9) 27 " +
//                "см Black/Red",43,"Поверхность приземления мужских беговых кроссовок ASICS GEL-" +
//                "Cumulus была увеличена с целью сохранения естественного движения стопы при каждом приземлении. " +
//                "Усовершенствованная посадка беговых кроссовок обеспечивает больший комфорт во время движения. Модель " +
//                "рассчитана на средние и длинные дистанции. Реализованная в них технология FlyteFoam дает повышенную " +
//                "пружинистость, а новая полноконтактная ходовая часть подошвы обеспечивает более плавное перемещение " +
//                "с пятки на носок. Колодка SpEVA обеспечивает достаточно места в области подошвенной дуги и носка, а " +
//                "ортопедическая стелька и система гелевой амортизации GEL Cushioning System создает непревзойденный " +
//                "комфорт с первой до последней минуты вашей пробежки. Новая рулонная манжета придает элегантность " +
//                "силуэту. Gel-Cumulus 20 сочетают в себе высокие рабочие характеристики, комфорт и стиль идеальной " +
//                "спортивной обуви. Вес 236 г",4449,1949,"Asics",
//                8823,126);
//        someGoods[20] = new Wear(94580091,"Шарф H&M 0624634-01 U Коричневый",61,
//                "Жаккардовый шарф из мягкого материала. На шарфе бахрома на концах. Размер 80x170 см.",
//                549,1947,"H&M",148000,92);
//
//        for (Goods x : someGoods) {
//            System.out.println(x.show());
//        }
    }
}
