package vagapov.core.block_two;

/**
 *Добавьте в класс Human 4 метода:
 * 1. getSecret()
 * 2. getNews()
 * 3. getExperience()
 * 4. getGossip()
 * которые помогут ему реализовать его желание делиться разной информацией с разными людьми.
 * Для этого используйте с методами нужные модификаторы доступа.
 *
 * Добавьте в класс конструктор для человека без секретов/новостей/опыта/сплетней (новорожденный)
 */
public class Human {
    public final String secret; //секретики
    public final String news; //новости
    public final String experience; //опыт
    public final String gossip; //сплетни


    public Human(String secret, String news, String experience, String gossip) {
        this.secret = secret;
        this.news = news;
        this.experience = experience;
        this.gossip = gossip;
    }
    public String getSecret(){
        return secret;
    }
    public String getNews(){
        return news;
    }
    public String getExperience() {
        return experience;
    }
    public String getGossip() {
        return gossip;
    }

    public Human (){
        this.secret = null;
        this.news = null;
        this.experience = null;
        this.gossip = null;
    }
}
