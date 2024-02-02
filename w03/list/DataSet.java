package week3.list;

/**
 * ������ �� ������ ��� ���� ����Ѵ�.
 */
public class DataSet {
	private double sum;			// ��
	private Measurable maximum;	// �ִ�
	private Measurable minimum;	// �ּڰ�
	private int count;			// ���� 
	
	public DataSet() {
		sum = 0;
		count= 0;
		maximum = null;
	}
	
	/**
	 * ������ �¿� ������ �ϳ��� �߰��Ѵ�.
	 * @param x ������ ��.
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
	 * ������ ������ ���� ����� ��ȯ�Ѵ�.
	 * @return
	 */
	public double getAverage() {
		if(count == 0)
			return 0;
		return sum / count;
	}
	
	/**
	 * ������ ������ ���� �� �ִ밪�� ��ȯ�Ѵ�.
	 * @return
	 */
	public Measurable getMaximum() {
		return maximum;
	}
	
	public Measurable getMinimum() {
		return minimum;
	}
}
