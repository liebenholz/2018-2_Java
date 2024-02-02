package week3.list;

/**
 * 데이터 셋 값들의 평균 값을 계산한다.
 */
public class DataSet {
	private double sum;			// 합
	private Measurable maximum;	// 최댓값
	private Measurable minimum;	// 최솟값
	private int count;			// 개수 
	
	public DataSet() {
		sum = 0;
		count= 0;
		maximum = null;
	}
	
	/**
	 * 데이터 셋에 데이터 하나를 추가한다.
	 * @param x 데이터 값.
	 */
	public void add(Measurable x) {
		sum = sum + x.getMeasure();
		if(count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		if(count == 0 || minimum.getMeasure() > x.getMeasure())
			minimum = x;
		count++;
	}

	/**
	 * 더해진 데이터 값의 평균을 반환한다.
	 * @return
	 */
	public double getAverage() {
		if(count == 0)
			return 0;
		return sum / count;
	}
	
	/**
	 * 더해진 데이터 값들 중 최대값을 반환한다.
	 * @return
	 */
	public Measurable getMaximum() {
		return maximum;
	}
	
	public Measurable getMinimum() {
		return minimum;
	}
}
