package onlineShop;
import onlineShop.model.Product;
import onlineShop.model.WordCount;
import javax.sql.DataSource;
import java.util.Properties;
import java.io.Serializable;

@Component
public class WordCount {
    @Autowired
    private SparkSession sparkSession;

    public List<Count> count() {
        String input = productDescription;
        String[] _words = input.split(" ");
        List<Word> words = Arrays.stream(_words).map(Word::new).collect(Collectors.toList());
        Dataset<Row> dataFrame = sparkSession.createDataFrame(words, Word.class);
        dataFrame.show();

        RelationalGroupedDataset groupedDataset = dataFrame.groupBy(col("word"));
        groupedDataset.count().show();
        List<Row> rows = groupedDataset.count().collectAsList();
        return rows.stream().map(new Function<Row, Count>() {
            @Override
            public Count apply(Row row) {
                return new Count(row.getString(0), row.getLong(1));
            }
        }).collect(Collectors.toList());
    }
}