package com.ck.test.search;

public class BinarySearch implements ISearch {
    @Override
    public int search(int[] a, int value, SearchModeEnum mode) {
        switch (mode) {
            case FIRST_EQUAL:
                return searchFirstEqual(a, value);
            case LAST_QUEAL:
                return searchLastEqual(a, value);
            case FIRST_GE:
                return searchFristGe(a, value);
            case LAST_LE:
                return searchFristLe(a, value);
            default:
                return search(a, value);
        }
    }

    private int search(int[] a, int value) {
        int mid = a.length >>1;
        int low = 0, high = a.length - 1;
        while (a[mid] != value) {
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            if (high == low) {
                if (a[low] == value) {
                    return low;
                } else {
                    return -1;
                }
            }
            if (high < low) {
                if (a[low] == value) {
                    return low;
                } else if(a[low+1] == value) {
                    return low + 1;
                } else {
                    return -1;
                }
            }
            mid = low + ((high - low) >> 1);
        }

        return mid;
    }

    private int searchFirstEqual(int[] a, int value) {
        int mid = a.length >>1;
        int low = 0, high = a.length - 1;
        while (true) {
            if (a[mid] == value) {
                if (mid == 0) {
                    return 0;
                }
                if (a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (a[mid] < value){
                low = mid + 1;
            }else {
                high = mid - 1;
            }

            if (high == low) {
                if (a[low] == value) {
                    return low;
                } else {
                    return -1;
                }
            }
            if (high < low) {
                if (a[low] == value) {
                    return low;
                } else if(a[low+1] == value) {
                    return low + 1;
                } else {
                    return -1;
                }
            }

            mid = low + ((high - low) >> 1);
        }
    }


    private int searchLastEqual(int[] a, int value) {
        int mid = a.length >>1;
        int low = 0, high = a.length - 1;
        while (true) {
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value){
                low = mid + 1;
            }else {
                if (mid == 0) {
                    return 0;
                }
                if (a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }

            if (high == low) {
                if (a[low] == value) {
                    return low;
                } else {
                    return -1;
                }
            }
            if (high < low) {
                if (a[low] == value) {
                    return low;
                } else if(a[low+1] == value) {
                    return low + 1;
                } else {
                    return -1;
                }
            }

            mid = low + ((high - low) >> 1);
        }
    }

    private int searchFristGe(int[] a, int value) {
        int mid = a.length >>1;
        int low = 0, high = a.length - 1;
        while (true) {
            if (a[mid] < value){
                low = mid + 1;
            }else {
                if (mid == 0) {
                    return 0;
                }
                if (a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }

            if (high == low) {
                if (a[low] == value) {
                    return low;
                } else {
                    return -1;
                }
            }
            if (high < low) {
                if (a[low] == value) {
                    return low;
                } else if(a[low+1] == value) {
                    return low + 1;
                } else {
                    return -1;
                }
            }

            mid = low + ((high - low) >> 1);
        }
    }

    private int searchFristLe(int[] a, int value) {
        return -1;
    }
}
