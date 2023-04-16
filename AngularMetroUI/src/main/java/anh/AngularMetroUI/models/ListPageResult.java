package anh.AngularMetroUI.models;

import java.util.List;

public class ListPageResult<T> {

	/**
	 * Выборка для текущей страницы
	 */
    public List<T> list;

    /**
     * Итоговое число записей в выбоке.
     */
    public Long totalCount;
}
