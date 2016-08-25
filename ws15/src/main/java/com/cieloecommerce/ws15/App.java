package com.cieloecommerce.ws15;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Cielo cielo = new Cielo("1006993069", "25fbb99741c739dd84d7b06ec78c9bac718838630f30b112d033ce2e621b34f3",
				Cielo.TEST);

		Holder holder = cielo.holder("4012001037141112", "201805", "123");
		Order order = cielo.order("213434", 10000);
		PaymentMethod paymentMethod = cielo.paymentMethod(PaymentMethod.Issuer.VISA,
				PaymentMethod.Product.CREDITO_A_VISTA);

		Transaction transaction = cielo.transaction(holder, order, paymentMethod,
				Transaction.AuthorizationMethod.AUTHORIZE_WITHOUT_AUTHENTICATION);
		transaction.setReturnUrl("http://localhost/cielo");
		transaction.setCapture(false);

		transaction = cielo.transactionRequest(transaction).execute();
		transaction = cielo.captureRequest(transaction.getTid()).execute();
		transaction = cielo.voidRequest(transaction.getTid()).execute();
		transaction = cielo.queryRequest(transaction.getTid()).execute();
		
		System.out.println(transaction.getTid());
	}
}
