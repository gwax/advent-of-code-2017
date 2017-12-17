package com.gwax.aoc2017.day12

fun mergeSets(sets: List<Set<Int>>): List<Set<Int>> {
    var merged = sets.toMutableList()
    var i = 0
    while (i < merged.size) {
        val left = merged[i]
        var j = i + 1
        while (j < merged.size) {
            val right = merged[j]
            if (left.intersect(right).isNotEmpty()) {
                merged[i] = left.union(right)
                merged.removeAt(j)
                i--
                break
            }
            j++
        }
        i++
    }
    return merged.toList()
}

fun parsePipes(input: String): List<Set<Int>> =
    input.lines()
            .map { it.split("[^\\d]+".toRegex())
                    .map { it.toInt() }
                    .toSet() }
            .toList()

fun main(args: Array<String>) {
    val pipeGroups = mergeSets(parsePipes(input))
    println(pipeGroups.find { it.contains(0) }?.size ?: 0)
    println(pipeGroups.size)
}

val input = """
0 <-> 122, 874, 1940
1 <-> 1099
2 <-> 743
3 <-> 594, 1258
4 <-> 4, 1473
5 <-> 109, 628, 1133, 1605
6 <-> 470, 561, 600, 1272, 1634
7 <-> 7, 1058, 1074, 1136
8 <-> 879
9 <-> 9
10 <-> 10, 1736
11 <-> 148, 1826
12 <-> 774, 1394, 1495
13 <-> 178, 410
14 <-> 666, 763, 1696
15 <-> 793, 1446, 1754, 1993
16 <-> 1477
17 <-> 1891, 1970
18 <-> 476, 1095
19 <-> 19
20 <-> 581, 1380, 1817, 1877
21 <-> 746, 1253
22 <-> 830, 1021
23 <-> 1115
24 <-> 89, 1436
25 <-> 759, 821
26 <-> 40, 1254
27 <-> 553, 1137, 1960
28 <-> 100, 808
29 <-> 279, 1223, 1591, 1726
30 <-> 236, 325, 769, 1132
31 <-> 425, 1377
32 <-> 611, 1047
33 <-> 751, 1797, 1828, 1921
34 <-> 1563, 1681
35 <-> 428
36 <-> 265, 1837
37 <-> 265, 365, 1455
38 <-> 1600, 1690
39 <-> 331
40 <-> 26, 560, 1512
41 <-> 911, 1991
42 <-> 835
43 <-> 680
44 <-> 1522
45 <-> 486, 1794
46 <-> 170, 334, 944, 1169
47 <-> 1086
48 <-> 274, 924
49 <-> 1664
50 <-> 721
51 <-> 1885
52 <-> 1143, 1205
53 <-> 148, 696
54 <-> 1637
55 <-> 936, 1781
56 <-> 342, 1212
57 <-> 911
58 <-> 692, 1456
59 <-> 59
60 <-> 463, 570, 1038, 1711
61 <-> 824, 1008, 1942
62 <-> 165, 1926
63 <-> 1689
64 <-> 64, 321
65 <-> 98, 116, 1082
66 <-> 1426, 1497
67 <-> 502, 951, 1514
68 <-> 215, 610, 803
69 <-> 264, 1660
70 <-> 417, 648, 1142
71 <-> 1937
72 <-> 744, 1158
73 <-> 466
74 <-> 74, 673
75 <-> 640, 1874
76 <-> 575, 708, 1347, 1488
77 <-> 435, 1648
78 <-> 412
79 <-> 347
80 <-> 807
81 <-> 176, 394
82 <-> 366, 928
83 <-> 737
84 <-> 84, 1537
85 <-> 1325
86 <-> 546
87 <-> 678, 941, 1229
88 <-> 1325
89 <-> 24, 89
90 <-> 431, 988, 1453
91 <-> 825, 957, 1249
92 <-> 937, 1516
93 <-> 1840
94 <-> 916, 1445
95 <-> 1628, 1998
96 <-> 123
97 <-> 355
98 <-> 65
99 <-> 425, 771, 1050
100 <-> 28, 100
101 <-> 337, 1257
102 <-> 270, 1754
103 <-> 103, 229
104 <-> 157, 916
105 <-> 1705
106 <-> 1165
107 <-> 1646
108 <-> 1082
109 <-> 5
110 <-> 485, 1185
111 <-> 944, 1249
112 <-> 112, 1056
113 <-> 1219
114 <-> 129, 617
115 <-> 422
116 <-> 65
117 <-> 200, 1802
118 <-> 243, 1507
119 <-> 732, 1103
120 <-> 160
121 <-> 320, 336
122 <-> 0, 582, 1931
123 <-> 96, 885, 1126, 1914
124 <-> 124, 413
125 <-> 125
126 <-> 367, 655
127 <-> 1290
128 <-> 1085
129 <-> 114, 1343, 1805
130 <-> 130, 1415
131 <-> 1626, 1734
132 <-> 296, 573, 1575
133 <-> 1713
134 <-> 1243, 1530
135 <-> 1048
136 <-> 153, 1209
137 <-> 137, 331
138 <-> 555, 1350
139 <-> 1035, 1345
140 <-> 393, 688
141 <-> 1037, 1998
142 <-> 736
143 <-> 716, 1362
144 <-> 1319
145 <-> 318, 445, 1471, 1608
146 <-> 146, 294
147 <-> 714
148 <-> 11, 53
149 <-> 364, 854, 1254
150 <-> 675, 1090
151 <-> 189, 1411, 1688
152 <-> 683, 1614
153 <-> 136, 1328, 1648
154 <-> 584, 1656
155 <-> 1972
156 <-> 1351
157 <-> 104, 1638
158 <-> 165
159 <-> 444, 1812
160 <-> 120, 859
161 <-> 984, 1769, 1943
162 <-> 1098
163 <-> 618
164 <-> 697, 922, 1688
165 <-> 62, 158, 1452, 1977
166 <-> 166, 1914
167 <-> 1996
168 <-> 260, 843, 1057, 1433
169 <-> 406, 736, 924
170 <-> 46
171 <-> 173, 833, 1104, 1149
172 <-> 1429
173 <-> 171, 1423
174 <-> 174, 332
175 <-> 655, 839
176 <-> 81, 176, 1264
177 <-> 177
178 <-> 13, 1162, 1182, 1951
179 <-> 842, 1620
180 <-> 1294, 1442, 1809
181 <-> 1633, 1783
182 <-> 182, 456
183 <-> 685
184 <-> 760, 1974
185 <-> 287, 775
186 <-> 917, 1541
187 <-> 412, 1119
188 <-> 395
189 <-> 151, 1370, 1792
190 <-> 1255, 1674
191 <-> 764, 1010
192 <-> 192, 607, 1717
193 <-> 1001, 1944
194 <-> 625
195 <-> 623
196 <-> 1882
197 <-> 1275
198 <-> 1069
199 <-> 1138, 1880
200 <-> 117
201 <-> 1605
202 <-> 1041, 1044
203 <-> 207, 301, 815, 1311
204 <-> 204, 1711
205 <-> 1298, 1562, 1602
206 <-> 228
207 <-> 203, 1480, 1713
208 <-> 786, 1844
209 <-> 1291, 1351, 1747
210 <-> 1320
211 <-> 587, 1340
212 <-> 587, 676
213 <-> 886
214 <-> 1549
215 <-> 68, 1115, 1371, 1701
216 <-> 1127
217 <-> 312
218 <-> 466, 1072, 1709
219 <-> 527
220 <-> 793
221 <-> 1314, 1800
222 <-> 1941
223 <-> 1911
224 <-> 224, 528
225 <-> 1030, 1084
226 <-> 569, 1599
227 <-> 658
228 <-> 206, 579, 800, 1381
229 <-> 103, 1975
230 <-> 1068
231 <-> 937
232 <-> 428
233 <-> 969, 1258
234 <-> 1824
235 <-> 1218
236 <-> 30, 1410, 1470, 1651
237 <-> 815
238 <-> 477, 1518, 1869
239 <-> 985, 1911
240 <-> 809, 1047
241 <-> 1379, 1577, 1692, 1757
242 <-> 1127
243 <-> 118
244 <-> 440, 747, 771, 1051
245 <-> 644, 725, 1332, 1862
246 <-> 395, 1168
247 <-> 1118
248 <-> 1462
249 <-> 737
250 <-> 1254
251 <-> 491, 1129
252 <-> 623
253 <-> 1046, 1872
254 <-> 1473
255 <-> 1220, 1672
256 <-> 1290, 1838
257 <-> 474, 1708, 1945
258 <-> 728, 1297
259 <-> 374, 464, 1637
260 <-> 168, 1699
261 <-> 677, 1164
262 <-> 1507
263 <-> 564
264 <-> 69, 264, 912
265 <-> 36, 37
266 <-> 1362
267 <-> 267
268 <-> 275, 1873
269 <-> 449, 766
270 <-> 102
271 <-> 1139, 1156
272 <-> 369, 584
273 <-> 311, 969
274 <-> 48, 667
275 <-> 268, 672, 1687
276 <-> 1609
277 <-> 490, 1252
278 <-> 1236, 1984
279 <-> 29
280 <-> 932, 1860
281 <-> 372, 638, 1311
282 <-> 1199, 1308
283 <-> 1938
284 <-> 315, 1375, 1799
285 <-> 1377, 1613
286 <-> 1661
287 <-> 185, 1248
288 <-> 409, 1457
289 <-> 1025
290 <-> 606, 1486, 1925
291 <-> 734, 1407
292 <-> 330
293 <-> 360, 1231
294 <-> 146, 1887
295 <-> 1237, 1733
296 <-> 132, 296, 621
297 <-> 1493, 1730
298 <-> 1958
299 <-> 696
300 <-> 1300
301 <-> 203
302 <-> 1188, 1349
303 <-> 750, 1701
304 <-> 304, 503
305 <-> 402, 630, 636, 1479
306 <-> 1007, 1350, 1502
307 <-> 1787
308 <-> 1485
309 <-> 479, 521
310 <-> 1415
311 <-> 273, 1942
312 <-> 217, 387, 1357
313 <-> 905, 1606
314 <-> 1337, 1627
315 <-> 284, 1509
316 <-> 1809
317 <-> 490, 1053, 1904
318 <-> 145, 1789
319 <-> 926, 1180
320 <-> 121, 1454, 1764
321 <-> 64, 725
322 <-> 762, 1178
323 <-> 918, 1064, 1957
324 <-> 1901
325 <-> 30
326 <-> 483, 1827
327 <-> 1360
328 <-> 546, 1576
329 <-> 526, 1667
330 <-> 292, 823
331 <-> 39, 137, 979
332 <-> 174, 703, 914
333 <-> 333, 1364
334 <-> 46
335 <-> 650
336 <-> 121, 1814
337 <-> 101
338 <-> 740, 1239
339 <-> 1595
340 <-> 1076, 1544
341 <-> 341, 623, 1540
342 <-> 56
343 <-> 367
344 <-> 1547, 1878
345 <-> 528
346 <-> 346, 626, 1036
347 <-> 79, 1052
348 <-> 368, 1950
349 <-> 631, 1765
350 <-> 602
351 <-> 1503, 1541, 1615, 1684
352 <-> 1341
353 <-> 824
354 <-> 703, 1868
355 <-> 97, 480, 566, 1804
356 <-> 648, 814
357 <-> 1656
358 <-> 504
359 <-> 763
360 <-> 293, 1296
361 <-> 361
362 <-> 1892
363 <-> 524
364 <-> 149, 1268
365 <-> 37, 1392, 1667
366 <-> 82, 606
367 <-> 126, 343, 677
368 <-> 348, 500, 1101, 1300
369 <-> 272, 527, 1785, 1833
370 <-> 370
371 <-> 1352, 1664
372 <-> 281
373 <-> 860, 1026, 1504
374 <-> 259, 919, 1635
375 <-> 990, 1489, 1835
376 <-> 1389
377 <-> 1063, 1750
378 <-> 423
379 <-> 1510
380 <-> 1983
381 <-> 517
382 <-> 1792
383 <-> 814
384 <-> 1826
385 <-> 1769
386 <-> 1632, 1931
387 <-> 312, 1206, 1961
388 <-> 868, 1713
389 <-> 721, 1781
390 <-> 604
391 <-> 493, 1691
392 <-> 1331
393 <-> 140
394 <-> 81, 1836
395 <-> 188, 246, 1171, 1388
396 <-> 981, 1475, 1617
397 <-> 397
398 <-> 931
399 <-> 1815
400 <-> 1245
401 <-> 1011
402 <-> 305, 1911
403 <-> 709
404 <-> 606, 709, 1067, 1988
405 <-> 1334, 1854
406 <-> 169, 1552
407 <-> 563
408 <-> 813
409 <-> 288, 409, 445
410 <-> 13, 577
411 <-> 1691
412 <-> 78, 187, 1089
413 <-> 124
414 <-> 803, 1858
415 <-> 415, 1289
416 <-> 549, 1519
417 <-> 70
418 <-> 1866
419 <-> 419, 680
420 <-> 1727
421 <-> 676, 1365
422 <-> 115, 467
423 <-> 378, 1470
424 <-> 436, 929, 1311
425 <-> 31, 99
426 <-> 934
427 <-> 596, 675, 936, 1580
428 <-> 35, 232, 1027
429 <-> 682, 1498
430 <-> 430
431 <-> 90
432 <-> 432, 1607
433 <-> 1312
434 <-> 1023, 1118
435 <-> 77, 435, 1280
436 <-> 424, 894
437 <-> 586, 1543
438 <-> 1118
439 <-> 439
440 <-> 244
441 <-> 441, 605
442 <-> 1274
443 <-> 443, 556
444 <-> 159
445 <-> 145, 409
446 <-> 1258
447 <-> 644, 940
448 <-> 1271, 1480
449 <-> 269, 1398
450 <-> 871, 1094
451 <-> 589, 1075
452 <-> 755
453 <-> 1518
454 <-> 613, 796
455 <-> 593
456 <-> 182, 1321, 1938
457 <-> 662, 1432
458 <-> 916, 1812
459 <-> 459
460 <-> 1920, 1926
461 <-> 1243, 1808, 1866
462 <-> 617, 693
463 <-> 60, 908
464 <-> 259, 1178
465 <-> 600
466 <-> 73, 218
467 <-> 422, 531, 750, 1476
468 <-> 468
469 <-> 901, 1204
470 <-> 6
471 <-> 755, 1257
472 <-> 514
473 <-> 873, 928
474 <-> 257, 784
475 <-> 1776
476 <-> 18, 1314
477 <-> 238
478 <-> 1825
479 <-> 309, 1605
480 <-> 355
481 <-> 1308
482 <-> 807
483 <-> 326, 619, 1098, 1776
484 <-> 1837
485 <-> 110, 525, 1601, 1893
486 <-> 45, 1581
487 <-> 1791
488 <-> 758
489 <-> 978
490 <-> 277, 317, 792
491 <-> 251, 1582
492 <-> 945, 1028
493 <-> 391, 1786
494 <-> 1661
495 <-> 534, 1255
496 <-> 690, 1480
497 <-> 631, 1195
498 <-> 892, 903
499 <-> 1522, 1941
500 <-> 368, 1449, 1624
501 <-> 706, 915, 1115
502 <-> 67
503 <-> 304
504 <-> 358, 1431, 1609, 1685
505 <-> 515
506 <-> 1347
507 <-> 624, 831
508 <-> 907
509 <-> 1127, 1970
510 <-> 821, 1599
511 <-> 763, 846
512 <-> 1779
513 <-> 537, 1033
514 <-> 472, 1068, 1888
515 <-> 505, 515
516 <-> 1363, 1644
517 <-> 381, 680
518 <-> 853
519 <-> 1703
520 <-> 1851
521 <-> 309
522 <-> 1831
523 <-> 1561
524 <-> 363, 1282, 1852
525 <-> 485, 1383
526 <-> 329, 876, 1399
527 <-> 219, 369, 1086
528 <-> 224, 345, 1243
529 <-> 719, 845, 980, 1778
530 <-> 530, 535
531 <-> 467
532 <-> 603, 1522
533 <-> 533
534 <-> 495, 1020
535 <-> 530, 639
536 <-> 789
537 <-> 513, 932, 1102
538 <-> 653, 784, 807
539 <-> 1186
540 <-> 1224
541 <-> 1068, 1320
542 <-> 1332
543 <-> 543, 1177
544 <-> 1404, 1567
545 <-> 842
546 <-> 86, 328, 1785
547 <-> 892, 1973
548 <-> 1686
549 <-> 416, 595, 1735
550 <-> 1928
551 <-> 850
552 <-> 552
553 <-> 27
554 <-> 554
555 <-> 138
556 <-> 443, 1389
557 <-> 748, 1656
558 <-> 758
559 <-> 596, 1812
560 <-> 40
561 <-> 6
562 <-> 562, 627, 1715
563 <-> 407, 776, 999
564 <-> 263, 633, 962, 1130, 1653
565 <-> 998
566 <-> 355
567 <-> 676, 1358
568 <-> 871, 1313, 1853
569 <-> 226
570 <-> 60, 1423
571 <-> 571, 880
572 <-> 778, 896, 1251
573 <-> 132, 685
574 <-> 1212
575 <-> 76, 1320, 1593
576 <-> 1237, 1760
577 <-> 410
578 <-> 1150, 1511, 1668
579 <-> 228, 1219, 1244
580 <-> 701
581 <-> 20
582 <-> 122, 1525
583 <-> 628, 1802
584 <-> 154, 272
585 <-> 698, 743, 1466, 1521
586 <-> 437, 1394
587 <-> 211, 212, 1856
588 <-> 1989
589 <-> 451
590 <-> 644, 1192
591 <-> 591
592 <-> 984, 1880
593 <-> 455, 789
594 <-> 3, 1526, 1844, 1902
595 <-> 549, 715, 1981
596 <-> 427, 559, 1316
597 <-> 1043, 1225
598 <-> 932
599 <-> 1064, 1065
600 <-> 6, 465
601 <-> 756, 946, 1050, 1570
602 <-> 350, 1809
603 <-> 532, 1010, 1060
604 <-> 390, 729
605 <-> 441
606 <-> 290, 366, 404
607 <-> 192
608 <-> 1826
609 <-> 953
610 <-> 68
611 <-> 32, 868
612 <-> 1213
613 <-> 454, 720
614 <-> 1872
615 <-> 615, 829, 1762
616 <-> 990, 1784
617 <-> 114, 462
618 <-> 163, 1508
619 <-> 483
620 <-> 686, 1446
621 <-> 296
622 <-> 622
623 <-> 195, 252, 341, 780, 1078
624 <-> 507
625 <-> 194, 1329
626 <-> 346
627 <-> 562
628 <-> 5, 583, 1876
629 <-> 1027, 1342, 1827
630 <-> 305, 1829
631 <-> 349, 497, 1248, 1728
632 <-> 1552
633 <-> 564
634 <-> 875, 1513
635 <-> 1150, 1410
636 <-> 305
637 <-> 637
638 <-> 281, 1877
639 <-> 535
640 <-> 75, 649, 804
641 <-> 967, 1739
642 <-> 1114, 1739
643 <-> 897, 981
644 <-> 245, 447, 590, 960
645 <-> 788, 1064, 1342
646 <-> 1217
647 <-> 675, 910, 1021
648 <-> 70, 356, 1893
649 <-> 640
650 <-> 335, 1903
651 <-> 651
652 <-> 758, 1836
653 <-> 538, 1515
654 <-> 902, 1322
655 <-> 126, 175
656 <-> 945, 1247
657 <-> 1957
658 <-> 227, 1231
659 <-> 737
660 <-> 915
661 <-> 692, 1299
662 <-> 457, 962, 1081
663 <-> 1410, 1852
664 <-> 664, 1969
665 <-> 872
666 <-> 14
667 <-> 274, 1871
668 <-> 994
669 <-> 1419, 1657
670 <-> 1275
671 <-> 671, 826
672 <-> 275, 928, 1330, 1619
673 <-> 74, 737, 1208
674 <-> 1863
675 <-> 150, 427, 647
676 <-> 212, 421, 567
677 <-> 261, 367, 677, 1023, 1306, 1405, 1725
678 <-> 87
679 <-> 1905
680 <-> 43, 419, 517, 1232, 1382, 1395, 1875
681 <-> 1845
682 <-> 429, 1368, 1625, 1990
683 <-> 152, 924, 1234
684 <-> 1247, 1628
685 <-> 183, 573
686 <-> 620, 1184, 1867
687 <-> 1080, 1636
688 <-> 140, 1205, 1363
689 <-> 1418, 1494
690 <-> 496
691 <-> 1013, 1178
692 <-> 58, 661, 1324, 1366
693 <-> 462, 693, 852
694 <-> 694
695 <-> 717
696 <-> 53, 299, 1979
697 <-> 164
698 <-> 585
699 <-> 1532
700 <-> 855
701 <-> 580, 744
702 <-> 1198, 1240
703 <-> 332, 354
704 <-> 1361
705 <-> 1101
706 <-> 501
707 <-> 707
708 <-> 76, 795, 1235, 1302
709 <-> 403, 404
710 <-> 806, 1358
711 <-> 711
712 <-> 924, 1569, 1990
713 <-> 1870
714 <-> 147, 1507
715 <-> 595
716 <-> 143, 1039
717 <-> 695, 1979
718 <-> 1476
719 <-> 529, 1061
720 <-> 613
721 <-> 50, 389, 1765
722 <-> 1058
723 <-> 723, 773, 1214
724 <-> 724
725 <-> 245, 321
726 <-> 938, 1010, 1366, 1670
727 <-> 1706
728 <-> 258, 1264
729 <-> 604, 729, 1396
730 <-> 1184
731 <-> 1524
732 <-> 119, 1962
733 <-> 1665, 1761
734 <-> 291
735 <-> 1022
736 <-> 142, 169, 1855
737 <-> 83, 249, 659, 673
738 <-> 933
739 <-> 1461, 1637
740 <-> 338, 1065
741 <-> 857, 943, 1100
742 <-> 742, 1400
743 <-> 2, 585, 743
744 <-> 72, 701, 1417, 1588
745 <-> 745
746 <-> 21, 1433, 1714
747 <-> 244
748 <-> 557
749 <-> 1225
750 <-> 303, 467
751 <-> 33
752 <-> 851
753 <-> 1398
754 <-> 1293
755 <-> 452, 471, 1868
756 <-> 601
757 <-> 1350, 1414
758 <-> 488, 558, 652
759 <-> 25, 1615
760 <-> 184, 1274
761 <-> 761
762 <-> 322, 819
763 <-> 14, 359, 511, 1542
764 <-> 191
765 <-> 1168
766 <-> 269, 1167
767 <-> 1109
768 <-> 1784
769 <-> 30, 769
770 <-> 1328
771 <-> 99, 244, 1310
772 <-> 1378
773 <-> 723, 882
774 <-> 12
775 <-> 185
776 <-> 563
777 <-> 817, 1559
778 <-> 572, 1198
779 <-> 1134
780 <-> 623, 1645
781 <-> 781
782 <-> 990, 1387, 1755
783 <-> 1015, 1391
784 <-> 474, 538, 1531, 1804
785 <-> 1802
786 <-> 208, 1357
787 <-> 787, 1233
788 <-> 645
789 <-> 536, 593, 1691
790 <-> 870, 1901
791 <-> 1888
792 <-> 490, 1469, 1999
793 <-> 15, 220, 1284, 1684, 1814
794 <-> 1648
795 <-> 708
796 <-> 454, 1286
797 <-> 797, 1014, 1028
798 <-> 1079, 1531
799 <-> 1159, 1351, 1526
800 <-> 228, 1176, 1819
801 <-> 1018
802 <-> 1735
803 <-> 68, 414, 1374, 1623
804 <-> 640, 867, 1955
805 <-> 805, 1843
806 <-> 710
807 <-> 80, 482, 538
808 <-> 28
809 <-> 240, 1246, 1582
810 <-> 810, 1005
811 <-> 811
812 <-> 812, 1359
813 <-> 408, 813
814 <-> 356, 383
815 <-> 203, 237, 848, 1720
816 <-> 816
817 <-> 777
818 <-> 1169, 1828
819 <-> 762
820 <-> 820, 1557
821 <-> 25, 510, 1288
822 <-> 1073, 1883
823 <-> 330, 925, 1323, 1883
824 <-> 61, 353, 1820
825 <-> 91, 1652
826 <-> 671
827 <-> 1183
828 <-> 843
829 <-> 615, 1661
830 <-> 22
831 <-> 507, 1054, 1439
832 <-> 855
833 <-> 171, 994, 1020
834 <-> 1706
835 <-> 42, 1951
836 <-> 836
837 <-> 1590
838 <-> 1001
839 <-> 175, 1329
840 <-> 1274
841 <-> 1933
842 <-> 179, 545, 1771
843 <-> 168, 828, 1032
844 <-> 847, 1790
845 <-> 529
846 <-> 511
847 <-> 844, 1077, 1172
848 <-> 815, 1338, 1397, 1452
849 <-> 1485, 1642
850 <-> 551, 1630
851 <-> 752, 1691, 1850
852 <-> 693
853 <-> 518, 1208, 1638, 1678
854 <-> 149
855 <-> 700, 832, 1450
856 <-> 856
857 <-> 741
858 <-> 1891
859 <-> 160, 1295, 1483
860 <-> 373, 1214
861 <-> 1134, 1564, 1961
862 <-> 862, 1794
863 <-> 942, 1671
864 <-> 864
865 <-> 1463, 1685
866 <-> 1411
867 <-> 804, 1492
868 <-> 388, 611
869 <-> 1417
870 <-> 790, 872, 1910
871 <-> 450, 568
872 <-> 665, 870
873 <-> 473
874 <-> 0, 1000, 1147, 1534
875 <-> 634, 1373, 1563
876 <-> 526, 1517
877 <-> 1911
878 <-> 878
879 <-> 8, 1887
880 <-> 571, 927
881 <-> 1945
882 <-> 773
883 <-> 909, 1141
884 <-> 1865
885 <-> 123, 1506
886 <-> 213, 1511
887 <-> 1413
888 <-> 1640
889 <-> 1629
890 <-> 890, 964, 1894
891 <-> 1242
892 <-> 498, 547, 1082
893 <-> 1035, 1555
894 <-> 436, 1108
895 <-> 1506, 1991
896 <-> 572, 1339
897 <-> 643, 1758
898 <-> 967, 1481
899 <-> 1094, 1791, 1976
900 <-> 900, 1003
901 <-> 469, 1420, 1751
902 <-> 654, 1503
903 <-> 498, 903, 1230
904 <-> 1226
905 <-> 313, 1208, 1749
906 <-> 1276, 1541
907 <-> 508, 1479
908 <-> 463
909 <-> 883, 909
910 <-> 647
911 <-> 41, 57, 1578
912 <-> 264
913 <-> 913, 1236
914 <-> 332, 1800
915 <-> 501, 660, 1386, 1429
916 <-> 94, 104, 458, 1075, 1899
917 <-> 186
918 <-> 323
919 <-> 374
920 <-> 920
921 <-> 1460
922 <-> 164, 922
923 <-> 1041
924 <-> 48, 169, 683, 712, 1107, 1700
925 <-> 823
926 <-> 319, 1381
927 <-> 880
928 <-> 82, 473, 672, 1201
929 <-> 424
930 <-> 930, 1569
931 <-> 398, 992
932 <-> 280, 537, 598, 1292
933 <-> 738, 1368
934 <-> 426, 1161
935 <-> 1086
936 <-> 55, 427
937 <-> 92, 231
938 <-> 726, 1304
939 <-> 958
940 <-> 447, 1222
941 <-> 87
942 <-> 863
943 <-> 741, 1421, 1832
944 <-> 46, 111
945 <-> 492, 656, 1353
946 <-> 601
947 <-> 1631
948 <-> 948
949 <-> 1434
950 <-> 1594
951 <-> 67, 1016, 1478
952 <-> 1641
953 <-> 609, 1176, 1513, 1714, 1958
954 <-> 954
955 <-> 955
956 <-> 982, 1217
957 <-> 91, 1106
958 <-> 939, 1199, 1303, 1944
959 <-> 1875
960 <-> 644
961 <-> 1619
962 <-> 564, 662, 1884
963 <-> 1015, 1851
964 <-> 890
965 <-> 1002
966 <-> 1793
967 <-> 641, 898
968 <-> 968
969 <-> 233, 273, 1212, 1978
970 <-> 1499, 1513
971 <-> 1106
972 <-> 1738
973 <-> 973
974 <-> 1646, 1967
975 <-> 1066
976 <-> 1287, 1640
977 <-> 1954
978 <-> 489, 1697
979 <-> 331
980 <-> 529
981 <-> 396, 643, 1376, 1925
982 <-> 956
983 <-> 1325, 1831
984 <-> 161, 592, 1579
985 <-> 239
986 <-> 1104, 1830
987 <-> 1419
988 <-> 90, 1718, 1737
989 <-> 1278, 1635
990 <-> 375, 616, 782, 1973
991 <-> 1852
992 <-> 931, 1722, 1724
993 <-> 1099
994 <-> 668, 833
995 <-> 1140, 1803
996 <-> 996, 1673
997 <-> 997
998 <-> 565, 998
999 <-> 563, 999
1000 <-> 874, 1160
1001 <-> 193, 838, 1011, 1710
1002 <-> 965, 1571
1003 <-> 900
1004 <-> 1004
1005 <-> 810, 1775
1006 <-> 1006
1007 <-> 306, 1447
1008 <-> 61
1009 <-> 1022, 1320
1010 <-> 191, 603, 726, 1344
1011 <-> 401, 1001
1012 <-> 1112, 1194
1013 <-> 691, 1031
1014 <-> 797
1015 <-> 783, 963
1016 <-> 951, 1989
1017 <-> 1213, 1818, 1824
1018 <-> 801, 1062
1019 <-> 1327
1020 <-> 534, 833
1021 <-> 22, 647, 1210
1022 <-> 735, 1009, 1413
1023 <-> 434, 677
1024 <-> 1071
1025 <-> 289, 1416, 1704
1026 <-> 373
1027 <-> 428, 629
1028 <-> 492, 797, 1113
1029 <-> 1038, 1268
1030 <-> 225, 1430
1031 <-> 1013
1032 <-> 843
1033 <-> 513
1034 <-> 1179
1035 <-> 139, 893, 1151
1036 <-> 346, 1598
1037 <-> 141, 1649
1038 <-> 60, 1029
1039 <-> 716, 1039
1040 <-> 1040, 1042
1041 <-> 202, 923, 1041
1042 <-> 1040, 1918
1043 <-> 597
1044 <-> 202
1045 <-> 1045
1046 <-> 253, 1394, 1770
1047 <-> 32, 240, 1748
1048 <-> 135, 1348
1049 <-> 1071
1050 <-> 99, 601, 1953
1051 <-> 244, 1345
1052 <-> 347, 1686
1053 <-> 317
1054 <-> 831, 1872
1055 <-> 1062, 1123, 1574, 1680
1056 <-> 112
1057 <-> 168
1058 <-> 7, 722
1059 <-> 1059
1060 <-> 603, 1277, 1669
1061 <-> 719
1062 <-> 1018, 1055
1063 <-> 377
1064 <-> 323, 599, 645, 1229, 1796
1065 <-> 599, 740, 1394
1066 <-> 975, 1867
1067 <-> 404, 1252, 1922
1068 <-> 230, 514, 541
1069 <-> 198, 1102
1070 <-> 1147
1071 <-> 1024, 1049, 1088, 1188
1072 <-> 218, 1434, 1447
1073 <-> 822, 1546
1074 <-> 7
1075 <-> 451, 916, 1610
1076 <-> 340
1077 <-> 847
1078 <-> 623, 1960
1079 <-> 798
1080 <-> 687
1081 <-> 662, 1238
1082 <-> 65, 108, 892
1083 <-> 1396
1084 <-> 225
1085 <-> 128, 1513, 1528
1086 <-> 47, 527, 935
1087 <-> 1616, 1823, 1826
1088 <-> 1071
1089 <-> 412
1090 <-> 150, 1652, 1865
1091 <-> 1091
1092 <-> 1742
1093 <-> 1408
1094 <-> 450, 899, 1719, 1783
1095 <-> 18
1096 <-> 1145
1097 <-> 1571, 1971
1098 <-> 162, 483, 1268
1099 <-> 1, 993, 1099, 1584
1100 <-> 741, 1100
1101 <-> 368, 705
1102 <-> 537, 1069
1103 <-> 119, 1586, 1939
1104 <-> 171, 986
1105 <-> 1211, 1443, 1913
1106 <-> 957, 971, 1568
1107 <-> 924, 1336, 1487, 1831
1108 <-> 894
1109 <-> 767, 1159, 1525
1110 <-> 1612, 1976
1111 <-> 1980
1112 <-> 1012, 1588
1113 <-> 1028
1114 <-> 642, 1197
1115 <-> 23, 215, 501
1116 <-> 1992
1117 <-> 1117
1118 <-> 247, 434, 438
1119 <-> 187, 1215, 1843
1120 <-> 1267, 1270
1121 <-> 1591, 1820
1122 <-> 1531, 1747
1123 <-> 1055
1124 <-> 1654
1125 <-> 1497
1126 <-> 123, 1425, 1729
1127 <-> 216, 242, 509
1128 <-> 1580
1129 <-> 251, 1302
1130 <-> 564
1131 <-> 1335, 1595
1132 <-> 30
1133 <-> 5, 1655
1134 <-> 779, 861
1135 <-> 1135
1136 <-> 7
1137 <-> 27
1138 <-> 199
1139 <-> 271, 1474
1140 <-> 995, 1430, 1474
1141 <-> 883
1142 <-> 70, 1886
1143 <-> 52, 1143
1144 <-> 1554
1145 <-> 1096, 1145
1146 <-> 1776, 1917
1147 <-> 874, 1070, 1240
1148 <-> 1444, 1451, 1961
1149 <-> 171
1150 <-> 578, 635, 1583
1151 <-> 1035, 1348
1152 <-> 1661
1153 <-> 1552
1154 <-> 1154, 1947
1155 <-> 1155, 1618
1156 <-> 271, 1677
1157 <-> 1491, 1592, 1884
1158 <-> 72, 1220
1159 <-> 799, 1109
1160 <-> 1000
1161 <-> 934, 1951
1162 <-> 178, 1242, 1905
1163 <-> 1474
1164 <-> 261
1165 <-> 106, 1165, 1676
1166 <-> 1166
1167 <-> 766, 1450, 1912, 1927
1168 <-> 246, 765
1169 <-> 46, 818
1170 <-> 1689
1171 <-> 395
1172 <-> 847, 1250, 1689
1173 <-> 1173
1174 <-> 1893
1175 <-> 1294
1176 <-> 800, 953
1177 <-> 543, 1315
1178 <-> 322, 464, 691
1179 <-> 1034, 1238
1180 <-> 319
1181 <-> 1996
1182 <-> 178, 1881
1183 <-> 827, 1552
1184 <-> 686, 730
1185 <-> 110, 1281
1186 <-> 539, 1217, 1809
1187 <-> 1242, 1257
1188 <-> 302, 1071, 1949, 1980
1189 <-> 1319
1190 <-> 1947
1191 <-> 1191
1192 <-> 590
1193 <-> 1204, 1260
1194 <-> 1012
1195 <-> 497
1196 <-> 1196, 1516
1197 <-> 1114
1198 <-> 702, 778
1199 <-> 282, 958
1200 <-> 1664
1201 <-> 928
1202 <-> 1202, 1355
1203 <-> 1203, 1966
1204 <-> 469, 1193
1205 <-> 52, 688
1206 <-> 387
1207 <-> 1993
1208 <-> 673, 853, 905
1209 <-> 136, 1462
1210 <-> 1021
1211 <-> 1105, 1211
1212 <-> 56, 574, 969, 1705
1213 <-> 612, 1017, 1663
1214 <-> 723, 860
1215 <-> 1119, 1615
1216 <-> 1524, 1798
1217 <-> 646, 956, 1186
1218 <-> 235, 1580
1219 <-> 113, 579, 1841
1220 <-> 255, 1158, 1681
1221 <-> 1331, 1360
1222 <-> 940
1223 <-> 29, 1237
1224 <-> 540, 1523
1225 <-> 597, 749, 1225
1226 <-> 904, 1226
1227 <-> 1934
1228 <-> 1228
1229 <-> 87, 1064
1230 <-> 903
1231 <-> 293, 658, 1402
1232 <-> 680, 1417
1233 <-> 787
1234 <-> 683
1235 <-> 708
1236 <-> 278, 913
1237 <-> 295, 576, 1223
1238 <-> 1081, 1179, 1326, 1806
1239 <-> 338
1240 <-> 702, 1147
1241 <-> 1921
1242 <-> 891, 1162, 1187, 1965
1243 <-> 134, 461, 528
1244 <-> 579
1245 <-> 400, 1245, 1864
1246 <-> 809, 1772
1247 <-> 656, 684
1248 <-> 287, 631
1249 <-> 91, 111, 1782
1250 <-> 1172
1251 <-> 572, 1508
1252 <-> 277, 1067, 1505
1253 <-> 21, 1639
1254 <-> 26, 149, 250
1255 <-> 190, 495
1256 <-> 1256, 1286
1257 <-> 101, 471, 1187
1258 <-> 3, 233, 446, 1309
1259 <-> 1398
1260 <-> 1193, 1517
1261 <-> 1300, 1807
1262 <-> 1508
1263 <-> 1973
1264 <-> 176, 728, 1307
1265 <-> 1265
1266 <-> 1507, 1720
1267 <-> 1120
1268 <-> 364, 1029, 1098
1269 <-> 1875
1270 <-> 1120, 1915
1271 <-> 448
1272 <-> 6
1273 <-> 1273
1274 <-> 442, 760, 840
1275 <-> 197, 670, 1450
1276 <-> 906
1277 <-> 1060
1278 <-> 989, 1878, 1986
1279 <-> 1279, 1848
1280 <-> 435, 1915
1281 <-> 1185
1282 <-> 524
1283 <-> 1678
1284 <-> 793, 1706
1285 <-> 1642
1286 <-> 796, 1256, 1630
1287 <-> 976, 1287
1288 <-> 821
1289 <-> 415
1290 <-> 127, 256
1291 <-> 209
1292 <-> 932
1293 <-> 754, 1293
1294 <-> 180, 1175, 1882
1295 <-> 859
1296 <-> 360, 1910
1297 <-> 258, 1426
1298 <-> 205
1299 <-> 661, 1954
1300 <-> 300, 368, 1261
1301 <-> 1834, 1847
1302 <-> 708, 1129
1303 <-> 958
1304 <-> 938
1305 <-> 1305
1306 <-> 677
1307 <-> 1264
1308 <-> 282, 481
1309 <-> 1258
1310 <-> 771, 1392
1311 <-> 203, 281, 424
1312 <-> 433, 1312, 1671
1313 <-> 568, 1409, 1861
1314 <-> 221, 476, 1549
1315 <-> 1177
1316 <-> 596
1317 <-> 1832
1318 <-> 1468
1319 <-> 144, 1189, 1319, 1542, 1923
1320 <-> 210, 541, 575, 1009
1321 <-> 456
1322 <-> 654
1323 <-> 823, 1385
1324 <-> 692
1325 <-> 85, 88, 983
1326 <-> 1238
1327 <-> 1019, 1387
1328 <-> 153, 770
1329 <-> 625, 839
1330 <-> 672
1331 <-> 392, 1221
1332 <-> 245, 542
1333 <-> 1333
1334 <-> 405, 1987
1335 <-> 1131, 1744
1336 <-> 1107
1337 <-> 314, 1379
1338 <-> 848
1339 <-> 896, 1523
1340 <-> 211, 1460
1341 <-> 352, 1459, 1849, 1878
1342 <-> 629, 645, 1752
1343 <-> 129
1344 <-> 1010
1345 <-> 139, 1051
1346 <-> 1845
1347 <-> 76, 506
1348 <-> 1048, 1151
1349 <-> 302
1350 <-> 138, 306, 757
1351 <-> 156, 209, 799, 1916
1352 <-> 371, 1352
1353 <-> 945, 1811
1354 <-> 1871
1355 <-> 1202, 1533
1356 <-> 1548, 1566, 1840
1357 <-> 312, 786
1358 <-> 567, 710
1359 <-> 812
1360 <-> 327, 1221, 1659
1361 <-> 704, 1901
1362 <-> 143, 266, 1551
1363 <-> 516, 688
1364 <-> 333
1365 <-> 421
1366 <-> 692, 726, 1972
1367 <-> 1367, 1946
1368 <-> 682, 933, 1465, 1478
1369 <-> 1369
1370 <-> 189
1371 <-> 215, 1572, 1870
1372 <-> 1372
1373 <-> 875
1374 <-> 803
1375 <-> 284
1376 <-> 981, 1545
1377 <-> 31, 285
1378 <-> 772, 1378
1379 <-> 241, 1337, 1587
1380 <-> 20, 1856
1381 <-> 228, 926
1382 <-> 680
1383 <-> 525
1384 <-> 1792
1385 <-> 1323, 1521
1386 <-> 915
1387 <-> 782, 1327
1388 <-> 395, 1416, 1525
1389 <-> 376, 556
1390 <-> 1390, 1406
1391 <-> 783, 1550, 1595
1392 <-> 365, 1310, 1793
1393 <-> 1505, 1667
1394 <-> 12, 586, 1046, 1065
1395 <-> 680
1396 <-> 729, 1083
1397 <-> 848, 1944
1398 <-> 449, 753, 1259
1399 <-> 526
1400 <-> 742
1401 <-> 1401
1402 <-> 1231
1403 <-> 1967
1404 <-> 544
1405 <-> 677
1406 <-> 1390
1407 <-> 291, 1407
1408 <-> 1093, 1947
1409 <-> 1313
1410 <-> 236, 635, 663
1411 <-> 151, 866
1412 <-> 1663
1413 <-> 887, 1022
1414 <-> 757, 1666
1415 <-> 130, 310
1416 <-> 1025, 1388
1417 <-> 744, 869, 1232, 1641
1418 <-> 689
1419 <-> 669, 987, 1419, 1431
1420 <-> 901
1421 <-> 943
1422 <-> 1422
1423 <-> 173, 570
1424 <-> 1424
1425 <-> 1126
1426 <-> 66, 1297
1427 <-> 1466
1428 <-> 1523, 1626
1429 <-> 172, 915
1430 <-> 1030, 1140
1431 <-> 504, 1419
1432 <-> 457
1433 <-> 168, 746
1434 <-> 949, 1072, 1474
1435 <-> 1688
1436 <-> 24, 1624
1437 <-> 1903
1438 <-> 1438, 1447
1439 <-> 831
1440 <-> 1788
1441 <-> 1441
1442 <-> 180
1443 <-> 1105
1444 <-> 1148
1445 <-> 94, 1693
1446 <-> 15, 620
1447 <-> 1007, 1072, 1438
1448 <-> 1617
1449 <-> 500
1450 <-> 855, 1167, 1275
1451 <-> 1148, 1556
1452 <-> 165, 848
1453 <-> 90, 1726
1454 <-> 320, 1869
1455 <-> 37
1456 <-> 58
1457 <-> 288
1458 <-> 1637
1459 <-> 1341
1460 <-> 921, 1340
1461 <-> 739, 1621
1462 <-> 248, 1209
1463 <-> 865
1464 <-> 1747
1465 <-> 1368
1466 <-> 585, 1427, 1655
1467 <-> 1467
1468 <-> 1318, 1468
1469 <-> 792
1470 <-> 236, 423
1471 <-> 145
1472 <-> 1485, 1857
1473 <-> 4, 254
1474 <-> 1139, 1140, 1163, 1434
1475 <-> 396, 1923
1476 <-> 467, 718
1477 <-> 16, 1478
1478 <-> 951, 1368, 1477
1479 <-> 305, 907, 1675
1480 <-> 207, 448, 496
1481 <-> 898, 1890
1482 <-> 1595
1483 <-> 859, 1502
1484 <-> 1545
1485 <-> 308, 849, 1472
1486 <-> 290
1487 <-> 1107
1488 <-> 76
1489 <-> 375
1490 <-> 1490
1491 <-> 1157, 1510
1492 <-> 867, 1492
1493 <-> 297, 1724
1494 <-> 689, 1494
1495 <-> 12
1496 <-> 1636
1497 <-> 66, 1125
1498 <-> 429
1499 <-> 970
1500 <-> 1664
1501 <-> 1954
1502 <-> 306, 1483
1503 <-> 351, 902
1504 <-> 373, 1980
1505 <-> 1252, 1393
1506 <-> 885, 895
1507 <-> 118, 262, 714, 1266
1508 <-> 618, 1251, 1262, 1611
1509 <-> 315
1510 <-> 379, 1491
1511 <-> 578, 886
1512 <-> 40
1513 <-> 634, 953, 970, 1085
1514 <-> 67
1515 <-> 653
1516 <-> 92, 1196, 1647
1517 <-> 876, 1260
1518 <-> 238, 453
1519 <-> 416, 1936
1520 <-> 1609
1521 <-> 585, 1385
1522 <-> 44, 499, 532
1523 <-> 1224, 1339, 1428, 1589
1524 <-> 731, 1216, 1524
1525 <-> 582, 1109, 1388
1526 <-> 594, 799
1527 <-> 1900, 1906
1528 <-> 1085
1529 <-> 1529, 1622
1530 <-> 134, 1994
1531 <-> 784, 798, 1122
1532 <-> 699, 1532
1533 <-> 1355, 1997
1534 <-> 874, 1992
1535 <-> 1777
1536 <-> 1798
1537 <-> 84
1538 <-> 1740
1539 <-> 1539
1540 <-> 341
1541 <-> 186, 351, 906
1542 <-> 763, 1319
1543 <-> 437, 1675
1544 <-> 340, 1544
1545 <-> 1376, 1484
1546 <-> 1073, 1987
1547 <-> 344, 1769
1548 <-> 1356, 1990
1549 <-> 214, 1314
1550 <-> 1391
1551 <-> 1362, 1929
1552 <-> 406, 632, 1153, 1183
1553 <-> 1916
1554 <-> 1144, 1721, 1984
1555 <-> 893
1556 <-> 1451, 1963
1557 <-> 820
1558 <-> 1558, 1623
1559 <-> 777, 1674
1560 <-> 1560
1561 <-> 523, 1564
1562 <-> 205, 1773, 1948, 1985
1563 <-> 34, 875
1564 <-> 861, 1561
1565 <-> 1941
1566 <-> 1356, 1779
1567 <-> 544, 1567
1568 <-> 1106
1569 <-> 712, 930
1570 <-> 601
1571 <-> 1002, 1097
1572 <-> 1371
1573 <-> 1573
1574 <-> 1055, 1942
1575 <-> 132
1576 <-> 328
1577 <-> 241
1578 <-> 911
1579 <-> 984
1580 <-> 427, 1128, 1218
1581 <-> 486
1582 <-> 491, 809, 1751, 1842
1583 <-> 1150
1584 <-> 1099, 1839
1585 <-> 1817
1586 <-> 1103
1587 <-> 1379
1588 <-> 744, 1112
1589 <-> 1523
1590 <-> 837, 1590
1591 <-> 29, 1121, 1603
1592 <-> 1157, 1592
1593 <-> 575
1594 <-> 950, 1767
1595 <-> 339, 1131, 1391, 1482
1596 <-> 1596
1597 <-> 1745
1598 <-> 1036
1599 <-> 226, 510
1600 <-> 38
1601 <-> 485, 1695, 1801
1602 <-> 205
1603 <-> 1591
1604 <-> 1604
1605 <-> 5, 201, 479
1606 <-> 313
1607 <-> 432
1608 <-> 145, 1906
1609 <-> 276, 504, 1520
1610 <-> 1075
1611 <-> 1508, 1641
1612 <-> 1110
1613 <-> 285
1614 <-> 152
1615 <-> 351, 759, 1215
1616 <-> 1087
1617 <-> 396, 1448
1618 <-> 1155, 1971
1619 <-> 672, 961
1620 <-> 179, 1739
1621 <-> 1461
1622 <-> 1529, 1893
1623 <-> 803, 1558
1624 <-> 500, 1436
1625 <-> 682
1626 <-> 131, 1428
1627 <-> 314
1628 <-> 95, 684
1629 <-> 889, 1629
1630 <-> 850, 1286
1631 <-> 947, 1631, 1952
1632 <-> 386, 1646
1633 <-> 181
1634 <-> 6, 1634
1635 <-> 374, 989
1636 <-> 687, 1496, 1839
1637 <-> 54, 259, 739, 1458
1638 <-> 157, 853
1639 <-> 1253
1640 <-> 888, 976, 1679
1641 <-> 952, 1417, 1611, 1810
1642 <-> 849, 1285, 1995
1643 <-> 1774, 1993, 1996
1644 <-> 516
1645 <-> 780
1646 <-> 107, 974, 1632
1647 <-> 1516
1648 <-> 77, 153, 794
1649 <-> 1037
1650 <-> 1843
1651 <-> 236
1652 <-> 825, 1090
1653 <-> 564
1654 <-> 1124, 1977
1655 <-> 1133, 1466
1656 <-> 154, 357, 557
1657 <-> 669
1658 <-> 1670
1659 <-> 1360, 1840
1660 <-> 69
1661 <-> 286, 494, 829, 1152
1662 <-> 1662, 1663
1663 <-> 1213, 1412, 1662
1664 <-> 49, 371, 1200, 1500, 1937
1665 <-> 733
1666 <-> 1414
1667 <-> 329, 365, 1393
1668 <-> 578, 1934
1669 <-> 1060, 1935
1670 <-> 726, 1658
1671 <-> 863, 1312, 1919
1672 <-> 255
1673 <-> 996
1674 <-> 190, 1559, 1815
1675 <-> 1479, 1543
1676 <-> 1165
1677 <-> 1156
1678 <-> 853, 1283, 1889
1679 <-> 1640
1680 <-> 1055
1681 <-> 34, 1220
1682 <-> 1690, 1757
1683 <-> 1879
1684 <-> 351, 793
1685 <-> 504, 865
1686 <-> 548, 1052, 1686
1687 <-> 275
1688 <-> 151, 164, 1435
1689 <-> 63, 1170, 1172
1690 <-> 38, 1682
1691 <-> 391, 411, 789, 851
1692 <-> 241
1693 <-> 1445
1694 <-> 1717
1695 <-> 1601
1696 <-> 14
1697 <-> 978, 1992
1698 <-> 1997
1699 <-> 260
1700 <-> 924
1701 <-> 215, 303
1702 <-> 1742
1703 <-> 519, 1905
1704 <-> 1025
1705 <-> 105, 1212
1706 <-> 727, 834, 1284
1707 <-> 1707
1708 <-> 257
1709 <-> 218
1710 <-> 1001
1711 <-> 60, 204
1712 <-> 1712
1713 <-> 133, 207, 388
1714 <-> 746, 953
1715 <-> 562
1716 <-> 1716
1717 <-> 192, 1694
1718 <-> 988
1719 <-> 1094
1720 <-> 815, 1266
1721 <-> 1554
1722 <-> 992
1723 <-> 1723
1724 <-> 992, 1493, 1745
1725 <-> 677, 1731
1726 <-> 29, 1453
1727 <-> 420, 1858
1728 <-> 631
1729 <-> 1126
1730 <-> 297, 1825
1731 <-> 1725
1732 <-> 1732, 1799
1733 <-> 295
1734 <-> 131
1735 <-> 549, 802
1736 <-> 10, 1757
1737 <-> 988, 1768
1738 <-> 972, 1844
1739 <-> 641, 642, 1620, 1739
1740 <-> 1538, 1961
1741 <-> 1935
1742 <-> 1092, 1702, 1903
1743 <-> 1845, 1945
1744 <-> 1335, 1744
1745 <-> 1597, 1724, 1745
1746 <-> 1975
1747 <-> 209, 1122, 1464
1748 <-> 1047
1749 <-> 905
1750 <-> 377, 1996
1751 <-> 901, 1582
1752 <-> 1342
1753 <-> 1974, 1998
1754 <-> 15, 102
1755 <-> 782, 1821
1756 <-> 1756
1757 <-> 241, 1682, 1736, 1959
1758 <-> 897
1759 <-> 1871
1760 <-> 576
1761 <-> 733, 1761
1762 <-> 615, 1882
1763 <-> 1825
1764 <-> 320
1765 <-> 349, 721
1766 <-> 1781
1767 <-> 1594, 1767
1768 <-> 1737
1769 <-> 161, 385, 1547
1770 <-> 1046
1771 <-> 842, 1930
1772 <-> 1246
1773 <-> 1562
1774 <-> 1643
1775 <-> 1005
1776 <-> 475, 483, 1146, 1822, 1928
1777 <-> 1535, 1777
1778 <-> 529, 1857
1779 <-> 512, 1566
1780 <-> 1780
1781 <-> 55, 389, 1766
1782 <-> 1249
1783 <-> 181, 1094, 1933
1784 <-> 616, 768
1785 <-> 369, 546
1786 <-> 493
1787 <-> 307, 1787
1788 <-> 1440, 1972
1789 <-> 318
1790 <-> 844, 1790
1791 <-> 487, 899
1792 <-> 189, 382, 1384
1793 <-> 966, 1392
1794 <-> 45, 862
1795 <-> 1944
1796 <-> 1064
1797 <-> 33
1798 <-> 1216, 1536
1799 <-> 284, 1732, 1924
1800 <-> 221, 914
1801 <-> 1601
1802 <-> 117, 583, 785
1803 <-> 995
1804 <-> 355, 784
1805 <-> 129
1806 <-> 1238, 1853
1807 <-> 1261
1808 <-> 461
1809 <-> 180, 316, 602, 1186
1810 <-> 1641
1811 <-> 1353
1812 <-> 159, 458, 559, 1833
1813 <-> 1880
1814 <-> 336, 793
1815 <-> 399, 1674
1816 <-> 1816
1817 <-> 20, 1585
1818 <-> 1017
1819 <-> 800
1820 <-> 824, 1121, 1898
1821 <-> 1755
1822 <-> 1776
1823 <-> 1087
1824 <-> 234, 1017
1825 <-> 478, 1730, 1763
1826 <-> 11, 384, 608, 1087, 1884
1827 <-> 326, 629
1828 <-> 33, 818
1829 <-> 630
1830 <-> 986
1831 <-> 522, 983, 1107
1832 <-> 943, 1317, 1860
1833 <-> 369, 1812
1834 <-> 1301
1835 <-> 375
1836 <-> 394, 652
1837 <-> 36, 484
1838 <-> 256, 1912
1839 <-> 1584, 1636
1840 <-> 93, 1356, 1659
1841 <-> 1219
1842 <-> 1582, 1892
1843 <-> 805, 1119, 1650
1844 <-> 208, 594, 1738
1845 <-> 681, 1346, 1743
1846 <-> 1846
1847 <-> 1301, 1847
1848 <-> 1279
1849 <-> 1341
1850 <-> 851, 1850
1851 <-> 520, 963
1852 <-> 524, 663, 991, 1936
1853 <-> 568, 1806
1854 <-> 405
1855 <-> 736
1856 <-> 587, 1380
1857 <-> 1472, 1778, 1893
1858 <-> 414, 1727, 1896, 1983
1859 <-> 1859
1860 <-> 280, 1832, 1895
1861 <-> 1313
1862 <-> 245
1863 <-> 674, 1863
1864 <-> 1245
1865 <-> 884, 1090
1866 <-> 418, 461
1867 <-> 686, 1066
1868 <-> 354, 755, 1909
1869 <-> 238, 1454
1870 <-> 713, 1371
1871 <-> 667, 1354, 1759
1872 <-> 253, 614, 1054
1873 <-> 268
1874 <-> 75, 1927
1875 <-> 680, 959, 1269
1876 <-> 628
1877 <-> 20, 638
1878 <-> 344, 1278, 1341, 1890
1879 <-> 1683, 1879
1880 <-> 199, 592, 1813
1881 <-> 1182
1882 <-> 196, 1294, 1762
1883 <-> 822, 823
1884 <-> 962, 1157, 1826
1885 <-> 51, 1923
1886 <-> 1142
1887 <-> 294, 879
1888 <-> 514, 791
1889 <-> 1678
1890 <-> 1481, 1878
1891 <-> 17, 858
1892 <-> 362, 1842
1893 <-> 485, 648, 1174, 1622, 1857
1894 <-> 890
1895 <-> 1860
1896 <-> 1858
1897 <-> 1897
1898 <-> 1820
1899 <-> 916
1900 <-> 1527
1901 <-> 324, 790, 1361, 1901
1902 <-> 594
1903 <-> 650, 1437, 1742, 1903, 1968
1904 <-> 317
1905 <-> 679, 1162, 1703
1906 <-> 1527, 1608, 1932
1907 <-> 1907
1908 <-> 1908
1909 <-> 1868
1910 <-> 870, 1296
1911 <-> 223, 239, 402, 877
1912 <-> 1167, 1838
1913 <-> 1105
1914 <-> 123, 166
1915 <-> 1270, 1280
1916 <-> 1351, 1553
1917 <-> 1146
1918 <-> 1042
1919 <-> 1671
1920 <-> 460
1921 <-> 33, 1241
1922 <-> 1067
1923 <-> 1319, 1475, 1885
1924 <-> 1799
1925 <-> 290, 981
1926 <-> 62, 460
1927 <-> 1167, 1874
1928 <-> 550, 1776
1929 <-> 1551
1930 <-> 1771
1931 <-> 122, 386
1932 <-> 1906
1933 <-> 841, 1783
1934 <-> 1227, 1668
1935 <-> 1669, 1741
1936 <-> 1519, 1852
1937 <-> 71, 1664
1938 <-> 283, 456
1939 <-> 1103
1940 <-> 0
1941 <-> 222, 499, 1565, 1941
1942 <-> 61, 311, 1574
1943 <-> 161
1944 <-> 193, 958, 1397, 1795
1945 <-> 257, 881, 1743
1946 <-> 1367
1947 <-> 1154, 1190, 1408
1948 <-> 1562, 1948
1949 <-> 1188
1950 <-> 348
1951 <-> 178, 835, 1161
1952 <-> 1631
1953 <-> 1050
1954 <-> 977, 1299, 1501
1955 <-> 804
1956 <-> 1956
1957 <-> 323, 657
1958 <-> 298, 953
1959 <-> 1757
1960 <-> 27, 1078
1961 <-> 387, 861, 1148, 1740
1962 <-> 732, 1962
1963 <-> 1556
1964 <-> 1964
1965 <-> 1242
1966 <-> 1203
1967 <-> 974, 1403
1968 <-> 1903
1969 <-> 664
1970 <-> 17, 509, 1970
1971 <-> 1097, 1618
1972 <-> 155, 1366, 1788
1973 <-> 547, 990, 1263
1974 <-> 184, 1753
1975 <-> 229, 1746
1976 <-> 899, 1110
1977 <-> 165, 1654
1978 <-> 969
1979 <-> 696, 717
1980 <-> 1111, 1188, 1504
1981 <-> 595
1982 <-> 1982
1983 <-> 380, 1858
1984 <-> 278, 1554
1985 <-> 1562
1986 <-> 1278
1987 <-> 1334, 1546
1988 <-> 404
1989 <-> 588, 1016
1990 <-> 682, 712, 1548
1991 <-> 41, 895
1992 <-> 1116, 1534, 1697
1993 <-> 15, 1207, 1643
1994 <-> 1530
1995 <-> 1642
1996 <-> 167, 1181, 1643, 1750
1997 <-> 1533, 1698
1998 <-> 95, 141, 1753
1999 <-> 792
""".trimIndent()