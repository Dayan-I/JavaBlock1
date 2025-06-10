package vagapov.core.block_five;


import jakarta.persistence.criteria.CriteriaBuilder;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Store {

    /**
     * Задание 1.
     * <p>
     * Магазину нужно сохранять информацию о продажах для каждого сотрудника.
     * Напишите метод который принимает String содержащий:
     * <p>
     * Алексей 3000
     * Дмитрий 9000
     * Антон 3000
     * <p>
     * Алексей 7000
     * Антон 8000
     * Метод должен заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма (Integer) всех его продаж.
     * <p>
     * Пример вывода:
     * {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}
     */

    public Map<String, Integer> getSalesMap(String value) {
        Map<String, Integer> salesMap = new HashMap<>();
        String[] sales = value.split("\n");
        for (int i = 0; i < sales.length; i++) {
            if (salesMap.containsKey(sales[i].split(" ")[0])) {
                salesMap.put(sales[i].split(" ")[0], (salesMap.get(sales[i].split(" ")[0]) + Integer.valueOf(sales[i].split(" ")[1])));
            } else salesMap.put(sales[i].split(" ")[0], Integer.valueOf(sales[i].split(" ")[1]));

        }
        return salesMap;
    }

    /**
     * Задание 2. Посложнее
     * <p>
     * Магазину нужно узнать кому из сотрудников следует повысить зарплату
     * Напишите метод который принимает:
     * 1 - карту empToPercentMap содержащий имя сотрудника и его процент продаж:
     * <p>
     * Алексей 60
     * Дмитрий 90
     * Антон 100
     * Алексей 30
     * Антон 70
     * <p>
     * 2 - карту empToSalaryMap содержащий имя сотрудника и его зарплату:
     * <p>
     * Алексей 3000
     * Дмитрий 9000
     * Антон 3000
     * Алексей 7000
     * Антон 8000
     * <p>
     * Метод должен вычислить средний процент продаж
     * и поднять зарплату сотрудникам у которых процент выше чем средний показатель на величину разницы процентов, например:
     * средний процент продаж - 60, у Дмитрия он составляет 90, значит 90-60 = 30, поднимаем зарплату Дмитрия на 30%
     * <p>
     * Метод должен вернуть мапу с ключом: "имя сотрудника" - значение: "сумма на которую повышаем зарплату", пример:
     * {Алексей=[0], Дмитрий=[3000]}
     * Доп условия:
     * 1. У кого процент продаж меньше чем среднее значение в мапу добавлять не нужно
     * 2. У тех у кого процент продаж = среднее значение, добавляем в мапу но ставим сумму равную "0"
     */
    public Map<String, Integer> findEmployeesForRaise(Map<String, Integer> empToPercentMap, Map<String, Integer> empToSalaryMap) {
        Collection<Integer> salesPercentList = empToPercentMap.values();
        Integer sum = 0;
        for (Integer i : salesPercentList) {
            sum += i;
        }
        Integer midPercent = sum / salesPercentList.size();
        List<String> empList = new ArrayList<>(empToPercentMap.keySet());
        Map<String, Integer> salaryMap = new HashMap<>();
        for (int i = 0; i < empList.size(); i++) {
            if ((empToPercentMap.get(empList.get(i)) > midPercent)) {
                salaryMap.put(empList.get(i), empToSalaryMap.get(empList.get(i)) / 100 * (empToPercentMap.get(empList.get(i)) - midPercent));
            } else if ((empToPercentMap.get(empList.get(i)) == midPercent)) {
                salaryMap.put(empList.get(i), 0);
            }
        }
        return salaryMap;
    }

}

