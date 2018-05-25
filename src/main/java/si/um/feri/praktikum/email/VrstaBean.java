package si.um.feri.praktikum.email;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")})
public class VrstaBean implements MessageListener {
    @EJB
    private EJBServiceActivator ejbServiceActivator;

    @Override
    public void onMessage(Message message) {
        if (message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;

            try {
                if (mapMessage.getInt("kateraMetoda") == 1) {
                    ejbServiceActivator.posljiMailNovemuClanu(mapMessage.getString("ime"), mapMessage.getString("priimek"), mapMessage.getString("email"));
                } else if (mapMessage.getInt("kateraMetoda") == 2) {
                    ejbServiceActivator.posljiMailNovemuTrenerju(mapMessage.getString("ime"), mapMessage.getString("priimek"), mapMessage.getString("upoIme"), mapMessage.getString("geslo"), mapMessage.getString("email"));
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
