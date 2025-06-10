package vagapov.core.block_five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * В данном классе вы будете работать преимущественно со списком - самой используемой коллекцией в работе
 *
 * Все приходящие списки иммутабельные поэтому напрямую из изменить не получиться
 */
public class GoodList {

    /**
     * По названию метода я думаю понятно что нужно сделать
     *
     * @param list список строк
     * @return список
     */
    public List<String> deleteDuplicates(List<String> list) {
        List<String> listWithoutDuplicates = new ArrayList<>();
        for (String s: list){
            if (!listWithoutDuplicates.contains(s)) {
                listWithoutDuplicates.add(s);
            }
        }
        return listWithoutDuplicates;
    }

    /**
     * По названию метода я думаю понятно что нужно сделать
     * Asc - тип сортировки
     *
     * @param list список строк
     * @return список
     */
    public List<String> getSortListAsc(List<String> list) {
        List<String> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * По названию метода я думаю понятно что нужно сделать
     *
     * @param listOne список строк c первыми элементами
     * @param listTwo список строк c вторыми элементами
     * @return список c совпадающими элементами
     *
     * Дубли не добавлять в список
     */
    public List<String> findIdenticalElements(List<String> listOne, List<String> listTwo) {
        List<String> indenticalElementsList = new ArrayList<>();
        for(String s : listTwo){
            if(listOne.contains(s)){
                if(!indenticalElementsList.contains(s)){
                    indenticalElementsList.add(s);
                }
            }
        }
        return indenticalElementsList;
    }
}
