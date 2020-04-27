package com.ck.test.stringsearch;

/**
 * 类    名: BmSearch </br>
 * 创建时间: 2020/4/25 </br>
 * 类 描 述: BM算法查找字符串</br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class BmSearch implements ISearch {

    @Override
    public int indexOf(char[] mainChars, char[] subChars) {
        long timestamp = System.currentTimeMillis();

        System.out.println("复制耗时: " + (System.currentTimeMillis() - timestamp));

        timestamp = System.currentTimeMillis();

        int[] bc = generateBC(subChars);
        int[] suffix = new int[subChars.length + 1];
        boolean[] prefix = new boolean[subChars.length + 1];
        generateGC(suffix, prefix, subChars);

        System.out.println("生成规则耗时: " + (System.currentTimeMillis() - timestamp));

        int i = 0;

//        int count = 0;
        while (i <= mainChars.length - subChars.length) {
//            count++;
//            System.out.println("进来第" + count + "次");
            int j = subChars.length - 1;
            for (; j >= 0 ; j--) {
                if (mainChars[i + j] != subChars[j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            // 好后缀长度是subChars.length - 1 - j
            int gcSlideLength = computeGC(suffix, prefix, subChars.length - 1 - j);
            int bcSlideLength = subChars.length - bc[mainChars[i + j]] - (subChars.length - j);
            i += Math.max(gcSlideLength, bcSlideLength);
        }
        return -1;
    }

    @Override
    public String getName() {
        return "BM算法";
    }

    // 生成坏字符数据
    private int[] generateBC(char[] chars) {
        int[] bc = new int[128];
        for (int i = 0; i < bc.length; i++) {
            bc[i] = -1;
        }
        for (int i = 0; i < chars.length - 1; i++) {
            bc[chars[i]] = i;
        }
        return bc;
    }

    // 生成好后缀规则
    private void generateGC(int[] suffix, boolean[] prefix, char[] subChars) {
        for (int i = 0; i < subChars.length; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }


        for (int i = 0; i < subChars.length - 1; i++) {
            int j = i;
            int k = 0;
            while (j >=0 && subChars[j] == subChars[subChars.length - 1 - k]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }

            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    // 计算好后缀需要向后移动多少位
    private int computeGC(int[] suffix, boolean[] prefix, int gcLength) {
        if (gcLength == 0) {
            return -1;
        }
        int subLength = suffix.length - 1;
        if (suffix[gcLength] != -1) {
            // 模式串中有与好后缀相同的子串, 直接让这个子串与主串对齐
            return subLength - gcLength - suffix[gcLength];
        }

        // 不存在跟好后缀相同的子串, 查找最长跟后缀子串相同的前缀子串
        for (int i = gcLength; i >= 1; i--) {
            if (prefix[i]) {
                return subLength - gcLength;
            }
        }

        // 也不存在最长跟后缀子串相同的前缀子串, 直接完全移动
        return subLength;
    }
}
