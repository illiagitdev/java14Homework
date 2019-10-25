import goods.categoris.*;
import goods.components.Brend;
import goods.components.ExpirationTime;
import goods.components.Warranty;
import goods.components.tech.*;
import store.Store;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Phone[] phone = new Phone[3];
        Computer[] computers = new Computer[3];
        Vegetable[] vegetables = new Vegetable[3];
        Sweets[] sweets = new Sweets[3];
        FreshWater[] freshWater = new FreshWater[3];
        SweetWater[] sweetWaters = new SweetWater[3];
        Clothes[] clothes = new Clothes[3];
        {
            phone[0] = new Phone(11, "Samsung Galaxy M30s 4/64GB Gradation Blue", 15,
                    "Экран (6.4\", Super AMOLED, 2340х1080) / Samsung Exynos 9611 (4 x 2.3 ГГц + 4 x 1.7 ГГц)", 7299);
            OperatingSystem system = new OperatingSystem();
            system.setOperatingSystem("Android 9.0 (Pie)");
            phone[0].setSystem(system);
            RAM ram = new RAM(4, "DDR5");
            phone[0].setRam(ram);
            CPU cpu = new CPU(8, (float) 2.3);
            phone[0].setCpu(cpu);
            ScreenDiagonal diagonal=new ScreenDiagonal((float) 6.3);
            phone[0].setDiagonal(diagonal);
            WorkingTime workingTime=new WorkingTime(12);
            phone[0].setWorkingTime(workingTime);
            Calendar expireDate = Calendar.getInstance();
            expireDate.set(2021, 1, 1);
            Warranty warranty = new Warranty(expireDate);
            phone[0].setWarranty(warranty);

            phone[1] = new Phone(12, "Motorola One Vision 4/128GB Bronze", 31, "Экран " +
                    "(6.3\", IPS, 2520x1080)/ Samsung Exynos 9609 (2.2 ГГц)/ двойная основная ", 7999);
             system = new OperatingSystem();
            system.setOperatingSystem("Android 9.0 (Pie)");
            phone[1].setSystem(system);
             ram = new RAM(4, "DDR5");
            phone[1].setRam(ram);
             cpu = new CPU(8, (float) 2.2);
            phone[1].setCpu(cpu);
             diagonal=new ScreenDiagonal((float) 6.3);
            phone[1].setDiagonal(diagonal);
             workingTime=new WorkingTime(15);
            phone[1].setWorkingTime(workingTime);
             expireDate = Calendar.getInstance();
            expireDate.set(2021, 1, 1);
             warranty = new Warranty(expireDate);
            phone[1].setWarranty(warranty);

            phone[2] = new Phone(13, "Xiaomi Mi 9 Lite 6/128GB Grey", 22,
                    "Экран (6.39\", AMOLED, 2340x1080)/ Qualcomm Snapdragon 710 (2.2 ГГц)", 8499);
            system.setOperatingSystem("Android 9.0 (Pie)");
            phone[1].setSystem(system);
            ram = new RAM(6, "DDR5");
            phone[1].setRam(ram);
            cpu = new CPU(8, (float) 2.2);
            phone[1].setCpu(cpu);
            diagonal=new ScreenDiagonal((float) 6.39);
            phone[1].setDiagonal(diagonal);
            workingTime=new WorkingTime(17);
            phone[1].setWorkingTime(workingTime);
            expireDate = Calendar.getInstance();
            expireDate.set(2021, 1, 1);
            warranty = new Warranty(expireDate);
            phone[1].setWarranty(warranty);
        }
        {
            computers[0] = new Computer(21, "IT-Blok Прогрессивный i9 7980XE B", 19, "Intel " +
                    "Core i9-7980XE — топовый процессор для настольной платформы Intel LGA 2066.", 157486);
            RAM ram = new RAM(128, "DDR4-3000 MHz");
            computers[0].setRam(ram);
            CPU cpu = new CPU(18, (float) 4.2);
            computers[0].setCpu(cpu);
            CPU gpu = new CPU(3584, (float) 1582);
            computers[0].setCpu(gpu);
            VideoRAM videoRAM = new VideoRAM((float) 11, "DDR5");
            VideoCard videoCard = new VideoCard(gpu, videoRAM);
            computers[0].setVideoCard(videoCard);
            Calendar expireDate = Calendar.getInstance();
            expireDate.set(2021, 1, 1);
            Warranty warranty = new Warranty(expireDate);
            computers[0].setWarranty(warranty);

            computers[1] = new Computer(22, "ARTLINE Gaming X48 v09", 41, "AMD Ryzen 5 1600 (3.2 - 3.6 ГГц) / RAM 16 ГБ " +
                    "/ HDD 1 ТБ + SSD 240 ГБ / AMD Radeon RX 580, 8 ГБ / без ОД / LAN / без ОС", 18360);
            ram = new RAM(16, "DDR4-2666 МГц");
            computers[1].setRam(ram);
            cpu = new CPU(6, (float) 3.6);
            computers[1].setCpu(cpu);
            gpu = new CPU(36, (float) 1257);
            computers[1].setCpu(gpu);
            videoRAM = new VideoRAM((float) 8, "DDR5");
            videoCard = new VideoCard(gpu, videoRAM);
            computers[1].setVideoCard(videoCard);
            expireDate = Calendar.getInstance();
            expireDate.set(2022, 1, 1);
            warranty = new Warranty(expireDate);
            computers[1].setWarranty(warranty);

            computers[2] = new Computer(23, "Lenovo IdeaCentre A340-22IGM", 32, "Экран 21.5\" (1920x1080) Full HD / Intel " +
                    "Pentium Silver J5005 (1.5 - 2.8 ГГц) / RAM 4 ГБ / SSD 128 ГБ / Intel UHD Graphics 605", 11355);
            ram = new RAM(4, "DDR4-2666 МГц");
            computers[2].setRam(ram);
            cpu = new CPU(4, (float) 2.8);
            computers[2].setCpu(cpu);
            gpu = new CPU(17, (float) 750);
            computers[2].setCpu(gpu);
            videoRAM = new VideoRAM((float) 1, "Intel UHD Graphics 605");
            videoCard = new VideoCard(gpu, videoRAM);
            computers[2].setVideoCard(videoCard);
            expireDate = Calendar.getInstance();
            expireDate.set(2020, 1, 1);
            warranty = new Warranty(expireDate);
            computers[2].setWarranty(warranty);
        }
        {
            vegetables[0] = new Vegetable(31, "Каштаны органические Markal 230 г", 132, "Очищенные плоды каштана, " +
                    "запеченны. Отличаются нежной структурой и сладковатым, ореховым вкусом.", 342);
            Calendar tmp = Calendar.getInstance();
            tmp.set(2019, 5, 12);
            Calendar tmp1 = Calendar.getInstance();
            tmp1.set(2022, 5, 25);
            ExpirationTime expire = new ExpirationTime(tmp, 15, tmp1);
            vegetables[0].setType("Сухие фрукты");
            vegetables[0].setExpirationTime(expire);
            vegetables[1] = new Vegetable(32, "Папайа сушеная Winway палочки 100 г", 321, "В сушеной папайе много " +
                    "витаминов. В этом продукте представлена почти вся витаминная цепочка от А до Е (особенно много " +
                    "аскорбиновой кислоты и витаминов группы В).", 40);
            tmp.set(2019, 7, 30);
            tmp1.set(2020, 7, 30);
            expire = new ExpirationTime(tmp, 20, tmp1);
            vegetables[1].setType("Сухие фрукты");
            vegetables[1].setExpirationTime(expire);
            vegetables[2] = new Vegetable(33, "Манго сушеный Seeberger ломтики 100 г", 431, "Ярко-оранжевые ломтики " +
                    "сушеного манго Seeberger одинаковой толщины, сочные, как спелый фрукт, и сладкие как мед.", 182);
            tmp.set(2019, 2, 3);
            tmp1.set(2020, 11, 4);
            expire = new ExpirationTime(tmp, 20, tmp1);
            vegetables[2].setType("Сухие фрукты");
            vegetables[2].setExpirationTime(expire);
        }
        {
            sweets[0] = new Sweets(41, "Маршмеллоу Millennium Барбекю Гриль 225 г", 436,
                    "Бельгийский маршмеллоу Millennium Барбекю Гриль.", 40);
            Calendar tmp = Calendar.getInstance();
            tmp.set(2019, 7, 26);
            Calendar tmp1 = Calendar.getInstance();
            tmp1.set(2020, 9, 25);
            ExpirationTime expire = new ExpirationTime(tmp, 25, tmp1);
            sweets[0].setExpirationTime(expire);
            sweets[1] = new Sweets(42, "Упаковка Яиц Kinder SpongeBob 20 г х 36 шт", 58, "Упаковка с 36 яйцами " +
                    "Kinder Сюрприз из молочного шоколада с молочным слоем.\nВнутри каждого яйца — оригинальная игрушка " +
                    "из серии SpongeBob. Собирайте яркую коллекцию вместе с Вашими малышами и Kinder.", 1220);
            tmp.set(2019, 6, 4);
            tmp1.set(2020, 6, 4);
            expire = new ExpirationTime(tmp, 15, tmp1);
            sweets[1].setExpirationTime(expire);
            sweets[2] = new Sweets(43, "Упаковка карамели-шипучки Chupa Chups B-Pop Тропические фрукты 15 г x 45 шт",
                    231, "Chupa Chups B-Pop — вкус тропических фруктов и шипучка сверху конфеты. Искрит тропически! Шипучая " +
                    "штучка!", 565);
            tmp.set(2019, 5, 21);
            tmp1.set(2021, 5, 21);
            expire = new ExpirationTime(tmp, 25, tmp1);
            sweets[2].setExpirationTime(expire);
        }
        {
            freshWater[0] = new FreshWater(51, "Упаковка минеральной лечебно-столовой сильногазированной воды " +
                    "Borjomi 0.5 л х 12 бутылок", 527, "Минеральная лечебно-столовая сильногазированная " +
                    "вода Borjomi - минеральная вода вулканического происхождения. Насыщенная природным углекислым газом, " +
                    "она способна подниматься на поверхность без помощи каких-либо насосов с глубины 8-10 км теплым потоком " +
                    "(38–41°С).", 280);
            freshWater[1] = new FreshWater(52, "Упаковка минеральной природной столовой негазированной воды " +
                    "Моршинська 0.5 л х 12 бутылок", 761, "Моршинские источники – одни из немногих в мире " +
                    "месторождений чистой природной воды.", 109);
            freshWater[2] = new FreshWater(53, "Упаковка минеральной негазированной воды Evian 0.33 л х 6 " +
                    "бутылок", 983, "Evian – это cамая известная в мире минеральная вода.",
                    199);
        }
        {
            sweetWaters[0] = new SweetWater(61, "Упаковка безалкогольного напитка Pepsi Max 1 л х 12 бутылок",
                    543, "Упаковка безалкогольного напитка Pepsi Max 1 л х 12 бутылок", 180);
            Calendar tmp = Calendar.getInstance();
            tmp.set(2019, 5, 5);
            Calendar tmp1 = Calendar.getInstance();
            tmp1.set(2019, 11, 5);
            ExpirationTime expire = new ExpirationTime(tmp, 15, tmp1);
            sweetWaters[0].setExpirationTime(expire);
            sweetWaters[1] = new SweetWater(62, "Упаковка безалкогольного напитка Coca-Cola 2 л х 6 бутылок",
                    641, "Coca-Cola была создана в Атланте, штат Джорджия, доктором Джоном С. Пембертоном в далеком 1886 " +
                    "году путем смешивания сиропа и воды.", 150);
            tmp.set(2019, 9, 7);
            tmp1.set(2020, 9, 7);
            expire = new ExpirationTime(tmp, 15, tmp1);
            sweetWaters[1].setExpirationTime(expire);
            sweetWaters[2] = new SweetWater(63, "Упаковка холодного кофе Капучино Landessa Ice Coffee Cappuccino 0.23 л " +
                    "х 12 банок", 92, "Холодный кофе Landessa Ice Coffee — Cappuccino в картонной эко-упаковке.", 542);
            tmp.set(2019, 8, 6);
            tmp1.set(2020, 8, 6);
            expire = new ExpirationTime(tmp, 18, tmp1);
            sweetWaters[2].setExpirationTime(expire);
        }
        {
            clothes[0] = new Clothes(71, "Куртка Colin’s CL1032686NAV L", 27, "Компания " +
                    "Colin's основана в 1983 году в городе Стамбул. Ее основателем стал начинающий предприниматель Нуреттин " +
                    "Эроглу (Nurettin Eroglu).",
                    1599);
            Brend brend = new Brend(1983, "COLIN`S", 8000, 25);
            clothes[0].setBrend(brend);
            clothes[1] = new Clothes(72, "Кроссовки для бега ASICS Gel-Cumulus 20 1011A008-001 42.5 (9) 27 " +
                    "см Black/Red", 43, "Поверхность приземления мужских беговых кроссовок ASICS GEL-" +
                    "Cumulus была увеличена с целью сохранения естественного движения стопы при каждом приземлении.", 4449);
            brend = new Brend(1949, "Asics", 8823, 126);
            clothes[1].setBrend(brend);
            clothes[2] = new Clothes(73, "Шарф H&M 0624634-01 U Коричневый", 61,
                    "Жаккардовый шарф из мягкого материала. На шарфе бахрома на концах. Размер 80x170 см.",
                    549);
            brend = new Brend(1947, "H&M", 148000, 92);
            clothes[2].setBrend(brend);
        }

        Operational store = new Operational();
        {
            Store trueStore = new Store();
            trueStore.setPhones(phone);
            trueStore.setComputers(computers);
            trueStore.setVegetables(vegetables);
            trueStore.setSweets(sweets);
            trueStore.setFreshWaters(freshWater);
            trueStore.setSweetWaters(sweetWaters);
            trueStore.setClothes(clothes);
            trueStore.setBalance(54000);

            store.setStore(trueStore);
        }
        //todo:продавать товары
        // - поле “кол-во” у соответствующего объекта должно отнять столько единиц товара, сколько было продано
        // - при продаже “кошелек магазина” пополняется на сумму проданных товаров
        // - нельзя продать больше товаров чем есть в наличии
        store.run();
    }
}
