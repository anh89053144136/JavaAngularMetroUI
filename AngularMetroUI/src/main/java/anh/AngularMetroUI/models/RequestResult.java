package anh.AngularMetroUI.models;

public class RequestResult<T> {

	public RequestResult()
    {
        message = "";
    }

	/**
	 * Статус ответа в виде перечисления, что бы
	 * на клиенте было использоватьв конструкциях if
	 */
    public ResultStatus code;

    /**
     * Сообщение, если во время выполнеия возникло исключение.
     * Должно содержаться понятное сообщение об ошибке.
     */
    public String message;

    /**
     * Если операция должна вернуть обьект или коллекцию.
     */
    public T result;
}
