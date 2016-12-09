.rdata
.align 2
$LC0:
       .ascii	"%d\000"
       .align 2
L10:
       .ascii	"[Pomme]\000"
       .align 2
L14:
       .ascii	"[Légume ancien Pané]\000"
       .align 2
L18:
       .ascii	"[Pommes de terre]\000"
       .align 2
L22:
       .ascii	"[Boudins Blanc]\000"
       .align 2
L26:
       .ascii	"[Carottes]\000"
       .align 2
L32:
       .ascii	"\012======================\012\000"
       .align 2
L33:
       .ascii	"\011\000"
       .align 2
L34:
       .ascii	": \000"
       .align 2
L35:
       .ascii	"\012\000"
       .align 2
L38:
       .ascii	"\012======================\012\000"
       .align 2
L39:
       .ascii	"Contenu du magasin:\012\000"
       .align 2
L42:
       .ascii	"Votre panier:\012\000"
       .align 2
L43:
       .ascii	"Reste dans le magasins:\012\000"
       .align 2
L44:
       .ascii	"\012======================\012\000"
       .align 2
L45:
       .ascii	"\011\000"
       .align 2
L46:
       .ascii	": \000"
       .align 2
L47:
       .ascii	"\012\000"
       .align 2
L50:
       .ascii	"\012======================\012\000"
       .align 2
L51:
       .ascii	"Combien de \000"
       .align 2
L52:
       .ascii	" souhaitez-vous acheter : \000"
       .align 2
L53:
       .ascii	"Il n'y a pas assez d'exemplaire dans le magasin\012\011Veuillez changer votre valeur: \000"
.text
# label printnomproduit
# beginfunc 
	.align	2
	.globl printnomproduit
	.ent printnomproduit
printnomproduit:
	 addiu	$sp,$sp,-36
	 sw	$31,16($29)
# var idproduit
# ifz idproduit goto L25
       lw  $8,36($29)
	beq  $8,0,L25
# var T_0
# T_0 = idproduit - 1
       li   $9, 1
	sub $9, $8, $9
# ifz T_0 goto L21
       sw  $9,24($29)
	beq  $9,0,L21
# var T_1
# T_1 = idproduit - 2
       li   $10, 2
	sub $10, $8, $10
# ifz T_1 goto L17
       sw  $10,28($29)
	beq  $10,0,L17
# var T_2
# T_2 = idproduit - 3
       li   $11, 3
	sub $11, $8, $11
# ifz T_2 goto L13
       sw  $11,32($29)
	beq  $11,0,L13
# arg L10
       lui   $12,%hi(L10)
       addiu   $12,$12,%lo(L10)
	 sw   $12,0($29)
	move   $4,$12
# call L4
	 jal   n_printf
	 nop
# goto L11
	j  L11
# label L13
L13:
# arg L14
       lui   $8,%hi(L14)
       addiu   $8,$8,%lo(L14)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# label L11
L11:
# goto L15
	j  L15
# label L17
L17:
# arg L18
       lui   $8,%hi(L18)
       addiu   $8,$8,%lo(L18)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# label L15
L15:
# goto L19
	j  L19
# label L21
L21:
# arg L22
       lui   $8,%hi(L22)
       addiu   $8,$8,%lo(L22)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# label L19
L19:
# goto L23
	j  L23
# label L25
L25:
# arg L26
       lui   $8,%hi(L26)
       addiu   $8,$8,%lo(L26)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# label L23
L23:
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,36
	 jr  $31
	 nop
	.end printnomproduit
# label checkpossiblevalue
# beginfunc 
	.align	2
	.globl checkpossiblevalue
	.ent checkpossiblevalue
checkpossiblevalue:
	 addiu	$sp,$sp,-48
	 sw	$31,16($29)
# var current
# var asked
# var compteur
# var returnvalue
# compteur = 0
       li   $8, 0
# returnvalue = 1
       li   $9, 1
# label L30
       sw  $8,24($29)
       sw  $9,28($29)
L30:
# var T_3
# T_3 = compteur - current
       lw  $9,24($29)
       lw  $8,48($29)
	sub $8, $9, $8
# var T_4
# T_4 = T_3 - 1
       li   $10, 1
	sub $10, $8, $10
# ifz T_4 goto L31
       sw  $8,32($29)
       sw  $10,36($29)
	beq  $10,0,L31
# var T_5
# T_5 = compteur - asked
       lw  $11,52($29)
	sub $11, $9, $11
# ifz T_5 goto L29
       sw  $11,40($29)
	beq  $11,0,L29
# returnvalue = 1
       li   $12, 1
# goto L27
       sw  $12,28($29)
	j  L27
# label L29
L29:
# return 0
       li   $2, 0
	 lw	$31,16($29)
	 addiu	$sp,$sp,48
	 jr  $31
	 nop
# label L27
L27:
# var T_6
# T_6 = compteur + 1
       lw  $9,24($29)
       li   $8, 1
	add $8, $9, $8
# compteur = T_6
       sw  $8,44($29)
# goto L30
       sw  $8,24($29)
	j  L30
# label L31
L31:
# return 1
       li   $2, 1
	 lw	$31,16($29)
	 addiu	$sp,$sp,48
	 jr  $31
	 nop
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,48
	 jr  $31
	 nop
	.end checkpossiblevalue
# label afficherpanier
# beginfunc 
	.align	2
	.globl afficherpanier
	.ent afficherpanier
afficherpanier:
	 addiu	$sp,$sp,-40
	 sw	$31,16($29)
# var panier
# var compteur
# compteur = 0
       li   $8, 0
# arg L32
       lui   $9,%hi(L32)
       addiu   $9,$9,%lo(L32)
	 sw   $9,0($29)
	move   $4,$9
# call L4
       sw  $8,24($29)
	 jal   n_printf
	 nop
# label L36
L36:
# var T_7
# T_7 = compteur - 5
       lw  $9,24($29)
       li   $8, 5
	sub $8, $9, $8
# ifz T_7 goto L37
       sw  $8,28($29)
	beq  $8,0,L37
# arg L33
       lui   $10,%hi(L33)
       addiu   $10,$10,%lo(L33)
	 sw   $10,0($29)
	move   $4,$10
# call L4
	 jal   n_printf
	 nop
# arg compteur
       lw  $8,24($29)
	 sw   $8,0($29)
	move   $4,$8
# call printnomproduit
	 jal   printnomproduit
	 nop
# arg L34
       lui   $8,%hi(L34)
       addiu   $8,$8,%lo(L34)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_8
# T_8 = panier [ compteur ]
       lw  $8,24($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,40($29)
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_8
       sw  $8,32($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L35
       lui   $8,%hi(L35)
       addiu   $8,$8,%lo(L35)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_9
# T_9 = compteur + 1
       lw  $9,24($29)
       li   $8, 1
	add $8, $9, $8
# compteur = T_9
       sw  $8,36($29)
# goto L36
       sw  $8,24($29)
	j  L36
# label L37
L37:
# arg L38
       lui   $8,%hi(L38)
       addiu   $8,$8,%lo(L38)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,40
	 jr  $31
	 nop
	.end afficherpanier
# label main
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-112
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# var magasins
# var panier
# var compteur
# compteur = 0
       li   $8, 0
# magasins [ 0 ] = 6
       li   $9, 0
       li   $10,4
       mult   $9,$10
       mflo   $9
       add   $10,$29,56
       add   $9,$9,$10
       li   $10, 6
       sw  $10,0($9)
# magasins [ 1 ] = 20
       li   $9, 1
       li   $11,4
       mult   $9,$11
       mflo   $9
       add   $11,$29,56
       add   $9,$9,$11
       li   $11, 20
       sw  $11,0($9)
# magasins [ 2 ] = 9
       li   $9, 2
       li   $12,4
       mult   $9,$12
       mflo   $9
       add   $12,$29,56
       add   $9,$9,$12
       li   $12, 9
       sw  $12,0($9)
# magasins [ 3 ] = 5
       li   $9, 3
       li   $13,4
       mult   $9,$13
       mflo   $9
       add   $13,$29,56
       add   $9,$9,$13
       li   $13, 5
       sw  $13,0($9)
# magasins [ 4 ] = 3
       li   $9, 4
       li   $14,4
       mult   $9,$14
       mflo   $9
       add   $14,$29,56
       add   $9,$9,$14
       li   $14, 3
       sw  $14,0($9)
# panier [ 0 ] = 0
       li   $9, 0
       li   $15,4
       mult   $9,$15
       mflo   $9
       add   $15,$29,76
       add   $9,$9,$15
       li   $15, 0
       sw  $15,0($9)
# panier [ 1 ] = 0
       li   $9, 1
       li   $16,4
       mult   $9,$16
       mflo   $9
       add   $16,$29,76
       add   $9,$9,$16
       li   $16, 0
       sw  $16,0($9)
# panier [ 2 ] = 0
       li   $9, 2
       li   $17,4
       mult   $9,$17
       mflo   $9
       add   $17,$29,76
       add   $9,$9,$17
       li   $17, 0
       sw  $17,0($9)
# panier [ 3 ] = 0
       li   $9, 3
       li   $18,4
       mult   $9,$18
       mflo   $9
       add   $18,$29,76
       add   $9,$9,$18
       li   $18, 0
       sw  $18,0($9)
# panier [ 4 ] = 0
       li   $9, 4
       li   $19,4
       mult   $9,$19
       mflo   $9
       add   $19,$29,76
       add   $9,$9,$19
       li   $19, 0
       sw  $19,0($9)
# arg L39
       lui   $9,%hi(L39)
       addiu   $9,$9,%lo(L39)
	 sw   $9,0($29)
	move   $4,$9
# call L4
       sw  $8,96($29)
	 jal   n_printf
	 nop
# arg magasins
	 add   $8,$29,56
	 sw   $8,0($29)
	move   $4,$8
# call affichermagasins
	 jal   affichermagasins
	 nop
# label L40
L40:
# var T_10
# T_10 = compteur - 5
       lw  $9,96($29)
       li   $8, 5
	sub $8, $9, $8
# ifz T_10 goto L41
       sw  $8,100($29)
	beq  $8,0,L41
# var T_11
# arg magasins
	 add   $10,$29,56
	 sw   $10,0($29)
	move   $4,$10
# arg compteur
	 sw   $9,4($29)
	move   $5,$9
# T_11 =  call acheter
	 jal   acheter
	 nop
# panier [ compteur ] = T_11
       lw  $8,96($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       add   $9,$29,76
       add   $8,$8,$9
       move  $9,$2
       sw  $9,0($8)
# var T_12
# T_12 = compteur + 1
       lw  $10,96($29)
       li   $8, 1
	add $8, $10, $8
# compteur = T_12
       sw  $8,108($29)
# goto L40
       sw  $2,104($29)
       sw  $8,96($29)
       sw  $9,104($29)
	j  L40
# label L41
L41:
# arg L42
       lui   $8,%hi(L42)
       addiu   $8,$8,%lo(L42)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# arg panier
	 add   $8,$29,76
	 sw   $8,0($29)
	move   $4,$8
# call afficherpanier
	 jal   afficherpanier
	 nop
# arg L43
       lui   $8,%hi(L43)
       addiu   $8,$8,%lo(L43)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# arg magasins
	 add   $8,$29,56
	 sw   $8,0($29)
	move   $4,$8
# call affichermagasins
	 jal   affichermagasins
	 nop
# endfunc 
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,112
	 jr  $31
	 nop
	.end main
# label affichermagasins
# beginfunc 
	.align	2
	.globl affichermagasins
	.ent affichermagasins
affichermagasins:
	 addiu	$sp,$sp,-40
	 sw	$31,16($29)
# var magasins
# var compteur
# compteur = 0
       li   $8, 0
# arg L44
       lui   $9,%hi(L44)
       addiu   $9,$9,%lo(L44)
	 sw   $9,0($29)
	move   $4,$9
# call L4
       sw  $8,24($29)
	 jal   n_printf
	 nop
# label L48
L48:
# var T_13
# T_13 = compteur - 5
       lw  $9,24($29)
       li   $8, 5
	sub $8, $9, $8
# ifz T_13 goto L49
       sw  $8,28($29)
	beq  $8,0,L49
# arg L45
       lui   $10,%hi(L45)
       addiu   $10,$10,%lo(L45)
	 sw   $10,0($29)
	move   $4,$10
# call L4
	 jal   n_printf
	 nop
# arg compteur
       lw  $8,24($29)
	 sw   $8,0($29)
	move   $4,$8
# call printnomproduit
	 jal   printnomproduit
	 nop
# arg L46
       lui   $8,%hi(L46)
       addiu   $8,$8,%lo(L46)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_14
# T_14 = magasins [ compteur ]
       lw  $8,24($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,40($29)
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_14
       sw  $8,32($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L47
       lui   $8,%hi(L47)
       addiu   $8,$8,%lo(L47)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_15
# T_15 = compteur + 1
       lw  $9,24($29)
       li   $8, 1
	add $8, $9, $8
# compteur = T_15
       sw  $8,36($29)
# goto L48
       sw  $8,24($29)
	j  L48
# label L49
L49:
# arg L50
       lui   $8,%hi(L50)
       addiu   $8,$8,%lo(L50)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,40
	 jr  $31
	 nop
	.end affichermagasins
# label acheter
# beginfunc 
	.align	2
	.globl acheter
	.ent acheter
acheter:
	 addiu	$sp,$sp,-44
	 sw	$31,16($29)
# var magasins
# var idproduit
# var quantiter
# arg L51
       lui   $8,%hi(L51)
       addiu   $8,$8,%lo(L51)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# arg idproduit
       lw  $8,48($29)
	 sw   $8,0($29)
	move   $4,$8
# call printnomproduit
	 jal   printnomproduit
	 nop
# arg L52
       lui   $8,%hi(L52)
       addiu   $8,$8,%lo(L52)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# quantiter =  call L8
       addiu   $5,$29,24
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_read_int
	 nop
       sw   $2,24($29)
# label L54
       sw  $2,24($29)
L54:
# var T_16
# var T_17
# T_17 = magasins [ idproduit ]
       lw  $8,48($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,44($29)
       add   $8,$8,$9
       lw  $8,0($8)
# arg T_17
       sw  $8,32($29)
	 sw   $8,0($29)
	move   $4,$8
# arg quantiter
       lw  $10,24($29)
	 sw   $10,4($29)
	move   $5,$10
# T_16 =  call checkpossiblevalue
	 jal   checkpossiblevalue
	 nop
# ifz T_16 goto L55
       sw  $2,28($29)
       move  $8,$2
	beq  $8,0,L55
# arg L53
       lui   $9,%hi(L53)
       addiu   $9,$9,%lo(L53)
	 sw   $9,0($29)
	move   $4,$9
# call L4
	 jal   n_printf
	 nop
# quantiter =  call L8
       addiu   $5,$29,24
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_read_int
	 nop
       sw   $2,24($29)
# goto L54
       sw  $2,24($29)
	j  L54
# label L55
L55:
# var T_18
# T_18 = magasins [ idproduit ]
       lw  $8,48($29)
       li   $9,4
       mult   $8,$9
       mflo   $8
       lw  $9,44($29)
       add   $8,$8,$9
       lw  $8,0($8)
# var T_19
# T_19 = T_18 - quantiter
       lw  $10,24($29)
	sub $10, $8, $10
# magasins [ idproduit ] = T_19
       lw  $11,48($29)
       li   $12,4
       mult   $11,$12
       mflo   $11
       add   $11,$11,$9
       sw  $10,0($11)
# return quantiter
       lw  $2,24($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,44
	 jr  $31
	 nop
# endfunc 
	 lw	$31,16($29)
	 addiu	$sp,$sp,44
	 jr  $31
	 nop
	.end acheter
